package io.neko.springsecurityservice.security.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.neko.springsecurityservice.security.model.Users;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class UsersReader {
    private final String fileName;

    public UsersReader(final String fileName) {
        this.fileName = fileName;
    }

    public Users readUsers() {
        URL fileUrl = getClass().getResource(this.fileName);
        if (fileUrl == null) {
            throw new RuntimeException(String.format("File [%s] is not exist", this.fileName));
        }
        File configFile = new File(fileUrl.getFile());
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Users users;
        try {
            users = mapper.readValue(configFile, Users.class);
        } catch (IOException e) {
            throw new RuntimeException(String.format("File [%s] can't be parsed as Users", this.fileName));
        }

        return users;
    }
}
