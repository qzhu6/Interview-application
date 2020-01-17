package com.bfs.backend.dao;

import com.bfs.backend.domain.EmailTemplate;

public interface EmailDAO {
    EmailTemplate getEmailByName(String EmailTemplateName);
}
