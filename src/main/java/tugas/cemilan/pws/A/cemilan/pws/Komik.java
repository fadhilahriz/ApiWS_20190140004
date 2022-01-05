/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.cemilan.pws.A.cemilan.pws;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author FADHIL
 */
@Entity
@Table(name="datakomik")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Komik {
    @Id
    private String idkomik;
    
    private String judulkomik;
    
    private String pengarang;
    
    private String penerbit;
    
    private String tahunterbit;
}
