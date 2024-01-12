package com.pdrake.musicdirectclone.security

import com.pdrake.musicdirectclone.repos.AccountRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(val accountRepository: AccountRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val account = accountRepository.getByUsername(username)
        if (account != null) {
            return User(account.username, account.password, account.roles.map {
                SimpleGrantedAuthority(it.authority)
            }.toList())
        }
        throw UsernameNotFoundException("Username does not exist")
    }
}
