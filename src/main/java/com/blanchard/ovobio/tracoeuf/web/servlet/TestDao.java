package com.blanchard.ovobio.tracoeuf.web.servlet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao extends JpaRepository<TestModel, Integer> {}
