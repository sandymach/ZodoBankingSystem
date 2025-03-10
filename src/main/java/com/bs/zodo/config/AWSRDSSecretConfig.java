package com.bs.zodo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.bs.zodo.dto.AWSSecrets;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AWSRDSSecretConfig {

    @Value("${aws.accessKeyId}")
    private String accessKey;
    @Value("${aws.secretAccessKey}")
    private String secretkey;

    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource() {
        AWSSecrets secrets = getSecret();
        return DataSourceBuilder
                .create()
                //  .driverClassName("com.mysql.cj.jdbc.driver")
                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/testdb")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }

    private AWSSecrets getSecret() {
        String secretName = "zodo-db-secret";
        String region = "eu-north-1";
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretkey)))
                        .build();
        String secret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;
        try {

            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
            secret = getSecretValueResult.getSecretString();
            AWSSecrets awsSecrets = gson.fromJson(secret, AWSSecrets.class);
            System.out.println("AWS Secrets==========" + awsSecrets.toString());
            return awsSecrets;

        } catch (Exception e) {
            throw e;
        }
    }
}
