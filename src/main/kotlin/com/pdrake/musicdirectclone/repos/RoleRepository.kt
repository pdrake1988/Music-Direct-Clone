package com.pdrake.musicdirectclone.repos

import com.pdrake.musicdirectclone.entities.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long>
