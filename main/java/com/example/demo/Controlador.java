package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class Controlador {
    @PostMapping("/register_users")
    public Users register_users(@RequestBody Users users) throws SQLException, ClassNotFoundException {

        String code = users.getCodeId();
        String thirdapp = users.getThirdapp();
        String relation = users.getRelation();
        String acronym = users.getAcronym();

        if (code == null || code.equals("") || code.length() < 0 || thirdapp == null || thirdapp.equals("") || thirdapp.length() < 0 ||
                relation == null || relation.equals("") || relation.length() < 0 || acronym == null || acronym.equals("") ||
                acronym.length() < 0) {

            return new Users(null, null, null, null);
        } else {
            BD bd = new BD();
            String name = bd.Select_acronym(acronym);
            if (name.equals("")) {
                return new Users(null, null, null, "Acronymo no existe");

            } else {
                users = bd.Register(code, thirdapp, relation, name);
            }
        }
        return users;
    }

    @PostMapping("/edit")
    public Users edit(@RequestBody Users users) throws SQLException, ClassNotFoundException {

        String code = users.getCodeId();
        String thirdapp = users.getThirdapp();
        String relation = users.getRelation();
        String acronym = users.getAcronym();

        if (code == null || code.equals("") || code.length() < 0 || thirdapp == null || thirdapp.equals("") || thirdapp.length() < 0 ||
                relation == null || relation.equals("") || relation.length() < 0 || acronym == null || acronym.equals("") ||
                acronym.length() < 0) {

            return new Users(null, null, null, null);
        } else {
            BD bd = new BD();
            String name = bd.Select_acronym(acronym);
            if (name.equals("")) {
                return new Users(null, null, null, "Acronymo no existe");

            } else {
                users = bd.Edit(code, thirdapp, relation, name);
            }
        }
        return users;
    }

    @GetMapping("/search")
    public List<Users> search() throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        List<Users> list = bd.Search_all();

        return list;
    }


}
