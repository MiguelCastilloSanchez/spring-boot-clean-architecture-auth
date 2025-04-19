package com.example.auth.infrastructure.config.db.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.auth.entity.admin.model.Admin;
import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class AdminSchema extends UserSchema {

  public AdminSchema() {
    this.role = "ROLE_ADMIN";
  }

  public AdminSchema(Admin admin) {
    super(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail(), admin.getPassword());

    this.role = "ROLE_ADMIN";
  }

  public Admin toAdmin() {
    Admin admin = new Admin (
            this.getUsername(),
            this.getPassword(),
            this.getName(),
            this.getEmail()
    );

    admin.setId(this.getId()); // transform the schema id (generated by database) to entity customer id

    return admin;
  }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return roles;
    }
}
