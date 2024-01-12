package com.pdrake.musicdirectclone.repos

import com.pdrake.musicdirectclone.entities.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun getByUsername(username: String?): Account?
}
