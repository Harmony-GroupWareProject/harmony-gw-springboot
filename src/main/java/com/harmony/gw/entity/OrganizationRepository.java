package com.harmony.gw.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OrganizationRepository extends CrudRepository<Organization, String> {

}
