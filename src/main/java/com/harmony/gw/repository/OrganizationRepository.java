package com.harmony.gw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harmony.gw.entity.Organization;

@RepositoryRestResource(exported = false)
public interface OrganizationRepository extends CrudRepository<Organization, String> {

}
