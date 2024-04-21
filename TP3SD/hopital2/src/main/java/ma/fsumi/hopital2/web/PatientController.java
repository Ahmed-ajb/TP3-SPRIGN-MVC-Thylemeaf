package ma.fsumi.hopital2.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.fsumi.hopital2.entities.Patient;
import ma.fsumi.hopital2.repository.Patientrespositoty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
public class PatientController {
    private Patientrespositoty patientrepositoty;
    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int p,
                        @RequestParam(name = "size",defaultValue = "4") int s,
                        @RequestParam(name="keyword",defaultValue = "") String kw)

    {
        Page<Patient> pagePatient=patientrepositoty.findByNomContains(kw,PageRequest.of(p,s));
        model.addAttribute("patients",pagePatient);
        model.addAttribute("listPatient", pagePatient.getContent());
        model.addAttribute("page", new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage", p);
        model.addAttribute("keyword",kw);
        return "patients";
    }
    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@RequestParam(name="id") Long id,
                         @RequestParam(name="keyword",defaultValue = "") String keyword,
                         @RequestParam(name="page" , defaultValue = "0") int page){
        patientrepositoty.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }
    @GetMapping("/admin/formPatients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatients";
    }
    @PostMapping(path = "/admin/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String nom,
                       @RequestParam String dateNaissance,
                       @RequestParam(defaultValue = "false") boolean malade,
                       @RequestParam int score,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword) {

        // Convert the dateNaissance String to a java.util.Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(dateNaissance);
        } catch (java.text.ParseException e) {
            // Handle the parse exception, for example, by logging it
            e.printStackTrace();
            // You might want to return an error view or redirect to the form
            return "redirect:/index";
        }

        Patient patient;

        if (id != null) {
            // Editing an existing patient
            patient = patientrepositoty.findById(id).orElse(null);
            if (patient == null) {
                // Handle case where patient with given ID is not found
                return "redirect:/index";
            }
        } else {
            // Adding a new patient
            patient = new Patient();
        }

        patient.setNom(nom);
        patient.setDateNaissace(parsedDate);
        patient.setMalade(malade);
        patient.setScore(score);

        patientrepositoty.save(patient);

        return "redirect:/user/index?page="+page+"&keyword"+keyword;
    }
    @PostMapping(path="/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword)
    {
        if(bindingResult.hasErrors()) return "formPatients";
        patientrepositoty.save(patient);
        return "redirect:/index?page="+page+"&keyword"+keyword;
    }
    @GetMapping("/admin/editPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editPatient(Model model,Long id ,String keyword,int page){
        Patient patient=patientrepositoty.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("Patient Introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editPatient";
    }


}
