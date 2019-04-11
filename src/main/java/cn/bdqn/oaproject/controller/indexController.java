package cn.bdqn.oaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class indexController {



        @RequestMapping("/index.html")
        public String index(){


            return "index";
        }

    @RequestMapping("/oaSystem.html")
    public String oaSystem(){
        return "oaSystem";
    }


    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/framework.html")
    public String framework(){
        return "framework";
    }


    @RequestMapping("/ask_for_leave_apply.html")
    public String ask_for_leave_apply(){
        return "ask_for_leave_apply";
    }

    @RequestMapping("/Business_card_printing_process.html")
    public String Business_card_printing_process(){
        return "Business_card_printing_process";
    }

    @RequestMapping("/Calendar_query.html")
    public String Calendar_query(){
        return "Calendar_query";
    }

    @RequestMapping("/chm_start.html")
    public String chm_start(){
        return "chm_start";
    }

    @RequestMapping("/Commonly_used_web_site.html")
    public String Commonly_used_web_site(){
        return "Commonly_used_web_site";
    }

    @RequestMapping("/Conference_room_manage.html")
    public String Conference_room_manage(){
        return "Conference_room_manage";
    }


    @RequestMapping("/dictionary_manage.html")
    public String dictionary_manage(){
        return "dictionary_manage";
    }

    @RequestMapping("/Document_recycle_bin.html")
    public String Document_recycle_bin(){
        return "Document_recycle_bin";
    }

    @RequestMapping("/inchapter_manage.html")
    public String inchapter_manage(){
        return "inchapter_manage";
    }



    @RequestMapping("/Library_application.html")
    public String Library_application(){
        return "Library_application";
    }




    @RequestMapping("/List_of_documents.html")
    public String List_of_documents(){
        return "List_of_documents";
    }



    @RequestMapping("/Mydesktop.html")
    public String Mydesktop(){
        return "Mydesktop";
    }




    @RequestMapping("/Notice_details_page.html")
    public String Notice_details_page(){
        return "Notice_details_page";
    }




    @RequestMapping("/Notification_list.html")
    public String Notification_list(){
        return "Notification_list";
    }



    @RequestMapping("/Notification_list_1.html")
    public String Notification_list_1(){
        return "Notification_list_1";
    }




    @RequestMapping("/onbusiness_apply.html")
    public String onbusiness_apply(){
        return "onbusiness_apply";
    }


    @RequestMapping("/operation_log.html")
    public String operation_log(){
        return "operation_log";
    }


    @RequestMapping("/Organizational_structure_manage.html")
    public String Organizational_structure_manage(){
        return "Organizational_structure_manage";
    }


    @RequestMapping("/Revenue_proof_process.html")
    public String Revenue_proof_process(){
        return "Revenue_proof_process";
    }




    @RequestMapping("/role_manage.html")
    public String role_manage(){
        return "role_manage";
    }






    @RequestMapping("/schedule_manage.html")
    public String schedule_manage(){
        return "schedule_manage";
    }





    @RequestMapping("/start.html")
    public String start(){
        return "start";
    }







    @RequestMapping("/start_c_1.html")
    public String start_c_1(){
        return "start_c_1";
    }


    @RequestMapping("/Transport_manage.html")
    public String Transport_manage(){
        return "Transport_manage";
    }

    @RequestMapping("/Upload_file_Settings.html")
    public String Upload_file_Settings(){
        return "Upload_file_Settings";
    }




    @RequestMapping("/user_manage.html")
    public String user_manage(){
        return "user_manage";
    }


    @RequestMapping("/waiting_task.html")
    public String waiting_task(){
        return "waiting_task";
    }

    @RequestMapping("/folder_name.html")
    public String   folder_name(){
        return "folder_name";
    }



}
