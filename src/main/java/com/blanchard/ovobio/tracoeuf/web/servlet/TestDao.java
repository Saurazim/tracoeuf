package com.blanchard.ovobio.tracoeuf.web.servlet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<TestModel, Integer> {}
