/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package tugas.cemilan.pws.A.cemilan.pws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author FADHIL
 */
@Controller
public class DBController {
    
    @CrossOrigin
    @RequestMapping(value="/datakomik/json", produces ={
        MediaType.APPLICATION_XML_VALUE
        }
    )
    @ResponseBody
    public List<Datakomik> getDatakomiks(){
        List<Datakomik> datakomik = new ArrayList<>();
        DatakomikJpaController controller = new DatakomikJpaController();
        
        try {
            datakomik = controller.findDatakomikEntities();
        }catch (Exception e) {}
        
        return datakomik;
    }
    
}
