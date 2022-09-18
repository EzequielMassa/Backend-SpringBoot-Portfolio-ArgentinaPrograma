package com.portfolio.ezequielmassa.security.controller;

import com.portfolio.ezequielmassa.model.About;
import com.portfolio.ezequielmassa.model.Education;
import com.portfolio.ezequielmassa.model.Experience;
import com.portfolio.ezequielmassa.model.ExperienceType;
import com.portfolio.ezequielmassa.model.Project;
import com.portfolio.ezequielmassa.model.Skill;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.security.Dto.JwtDto;
import com.portfolio.ezequielmassa.security.Dto.LoginUsuario;
import com.portfolio.ezequielmassa.security.Dto.NuevoUsuario;
import com.portfolio.ezequielmassa.security.Entity.Rol;
import com.portfolio.ezequielmassa.security.Entity.Usuario;
import com.portfolio.ezequielmassa.security.enums.RolNombre;
import com.portfolio.ezequielmassa.security.jwt.JwtProvider;
import com.portfolio.ezequielmassa.security.service.RolService;
import com.portfolio.ezequielmassa.security.service.UsuarioService;
import com.portfolio.ezequielmassa.service.ExperienceTypeService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ezem
 */
@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioServ;
    
    @Autowired
    ExperienceTypeService expTypeServ;

    @Autowired
    RolService rolServ;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos incorrectos o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioServ.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioServ.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolServ.getByRolNombre(RolNombre.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolServ.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);

        UsuarioInfo newUsuarioInfo = new UsuarioInfo(usuario.getNombre(), "", "", "", "https://yt3.ggpht.com/9upo5zbtXzvItj8IMHF1X9hI95x4YOeGCApLk1DhMQCHftmJvf2GWmbJXrC1TKCrn-AyQ2txBw=s900-c-k-c0x00ffffff-no-rj", "https://argentinaprograma.inti.gob.ar/pluginfile.php/1/theme_moove/sliderimage1/1661403264/banner-ok-argentina-programa.jpg");

        About acerca = new About("");
      
        ExperienceType exptype1 = new ExperienceType(1,"Part-Time");
        ExperienceType exptype2 = new ExperienceType(2,"Full-Time");
        ExperienceType exptype3 = new ExperienceType(3,"Freelance");
        
        expTypeServ.guardarTipoExperiencia(exptype1);
        expTypeServ.guardarTipoExperiencia(exptype2);
        expTypeServ.guardarTipoExperiencia(exptype3);
        
        List<Experience> experiencias = new ArrayList<>();
        List<Education> educations = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        newUsuarioInfo.setAcerca(acerca);
      
        newUsuarioInfo.setExperiencias(experiencias);
        newUsuarioInfo.setEducations(educations);
        newUsuarioInfo.setSkills(skills);
        newUsuarioInfo.setProjects(projects);
        
        usuario.setUsuarioInfo(newUsuarioInfo);
        usuarioServ.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
