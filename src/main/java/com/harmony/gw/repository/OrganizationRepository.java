package com.harmony.gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harmony.gw.entity.Organization;

@RepositoryRestResource(exported = false)
public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
