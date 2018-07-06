package com.neoris.microservicios.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neoris.microservicios.dao.IUsuarioDAO;
import com.neoris.microservicios.entity.Usuario;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Override
	public UserDetails loadUserByUsername(String usuarioNombre)
			throws UsernameNotFoundException {
		Usuario usuarioActivoInfo = usuarioDAO.getUsuarioActivo(usuarioNombre);
		GrantedAuthority authority = new SimpleGrantedAuthority(usuarioActivoInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(usuarioActivoInfo.getUserName(),
				usuarioActivoInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}