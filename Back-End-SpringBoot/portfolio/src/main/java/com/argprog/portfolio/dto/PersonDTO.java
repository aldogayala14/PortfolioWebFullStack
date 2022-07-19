package com.argprog.portfolio.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String nationality;
    private String aboutMe;
    private String occupation;
    private String imageBackgroundHeader;
    private String imageProfile;
    private Long residenceId;
    private List<LanguageDTO> languages;
    private List<WorkExperiencieDTO> experiencies;
    private List<EducationDTO> educations;
    private List<TechnologyDTO> technologies;
    private List<ProjectDTO> projects;

}
