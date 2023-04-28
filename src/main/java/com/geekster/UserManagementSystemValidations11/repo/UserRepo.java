package com.geekster.UserManagementSystemValidations11.repo;

import com.geekster.UserManagementSystemValidations11.model.User;
//import jakarta.validation.constraints.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



//import static jdk.internal.org.jline.utils.Colors.s;


@Repository
public class UserRepo {

    HashMap<String ,  User> hm = new HashMap<>();

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        for(String userId : hm.keySet()){
            userList.add(hm.get(userId));
        }
        return userList;
    }

    public String addUser(User user) {
        if(hm.containsKey(user.getUserId())){
            return "Can not add User has the user with userId "+user.getUserId() + " already exits";
        }
        hm.put(user.getUserId(), user);
        return "User with userId "+user.getUserId() +" added successfully";
    }

    public User getUserById(String userId) {
        if(!hm.containsKey(userId)){
            return null;
        }
        return hm.get(userId);
    }

    public String updateUserInfo(String userId , User user) {
        if(hm.containsKey(userId)){
            User originalUser = hm.get(userId);
//            StringBuilder sb = new StringBuilder();
            JSONArray jsonArray = new JSONArray();

            if(!(user.getUserName()==null)){
                JSONObject json  = new JSONObject();
                if(user.getUserName().isEmpty()){
                    json.put("field" , "userName");
                    json.put("msg","userName should not be empty");
                }else{
                    originalUser.setUserName(user.getUserName());

                    json.put("field" , "userName");
                    json.put("msg","userName updated sucessfully");
                }

                jsonArray.put(json);
            }
            if(!(user.getDateOfBirth()==null)){
                Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
                Matcher m = p.matcher(user.getDateOfBirth());
                JSONObject json  = new JSONObject();
                if( (m.find() && m.group().equals(user.getDateOfBirth()))){
                    originalUser.setDateOfBirth(user.getDateOfBirth());
                    json.put("field" , "DateOfBirth");
                    json.put("msg","DateOfBirth updated sucessfully");
                }else{
                    json.put("field" , "DateOfBirth");
                    json.put("msg","DateOfBirth not updated please enter valid DOB");
                }
                jsonArray.put(json);
            }
            if(!(user.getEmail()==null)){
                Pattern p = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
                Matcher m = p.matcher(user.getEmail());
                JSONObject json  = new JSONObject();
                if( (m.find() && m.group().equals(user.getEmail()))){
                    originalUser.setEmail(user.getEmail());
                    json.put("field" , "email");
                    json.put("msg","email updated sucessfully");
                }else{
                    json.put("field" , "email");
                    json.put("msg","email not updated please enter valid email");
                }
                jsonArray.put(json);
            }
            if(!(user.getPhoneNumber()==null)){
                Pattern p = Pattern.compile("\\d{2}-\\d{10}");
                JSONObject json  = new JSONObject();
                Matcher m = p.matcher(user.getPhoneNumber());
                if( (m.find() && m.group().equals(user.getPhoneNumber()))){
                    originalUser.setPhoneNumber(user.getPhoneNumber());
                    json.put("field" , "phoneNumber");
                    json.put("msg","phoneNumber updated sucessfully");
//                    sb.append( "phone number updated");
                }else{
                    json.put("field" , "phoneNumber");
                    json.put("msg","phoneNumber not updated please enter valid phoneNumber");
                }
                jsonArray.put(json);

            }
            if(!(user.getDate()==null)){
                Pattern p = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$");
                JSONObject json  = new JSONObject();
                Matcher m = p.matcher(user.getDate());
                if( (m.find() && m.group().equals(user.getDate()))){
                    originalUser.setDate(user.getDate());
                    json.put("field" , "date");
                    json.put("msg","date updated sucessfully");
                }else{
                    json.put("field" , "date");
                    json.put("msg","date not updated please enter valid date");
                }
                jsonArray.put(json);

            }
            if(!(user.getTime()==null)){
                Pattern p = Pattern.compile("^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");
                JSONObject json  = new JSONObject();
                Matcher m = p.matcher(user.getTime());
                if( (m.find() && m.group().equals(user.getTime()))){
                    originalUser.setTime(user.getTime());
                    json.put("field" , "time");
                    json.put("msg","time updated sucessfully");
                }else{
                    json.put("field" , "time");
                    json.put("msg","time not updated please enter valid time");
                }
                jsonArray.put(json);
            }
            return jsonArray.toString();
//            return jsonArray.toString();
        }else{
            return "User with userId "+userId+" was not found";
        }

    }

    public String deleteUser(String userId) {
        if(hm.containsKey(userId)){
            hm.remove(userId);
        }

        return "User with userId "+userId+" was not found";
    }
}
