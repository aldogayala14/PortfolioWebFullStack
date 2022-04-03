package com.argprog.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "persons")
@Getter
@Setter
public class PersonEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String email;
    private String nationality;
    private String aboutMe;
    private String occupation;

    private String imageBackgroundHeader;
    private String imageProfile;

    @OneToMany(mappedBy = "person")
    private Set<ResidenceEntity> residences= new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "personExperience")
    private Set<WorkExperienceEntity> workExperiences = new HashSet<>();

    @OneToMany(mappedBy = "personEducation")
    private Set<EducationEntity> educations = new HashSet<>();

    @OneToMany(mappedBy = "personTechnology")
    private Set<TechnologyEntity> technologies = new HashSet<>();

    @OneToMany(mappedBy = "personProject")
    private Set<ProjectEntity> projects = new HashSet<>();

    @OneToMany(mappedBy = "personLanguage")
    private Set<LanguageEntity> languages = new HashSet<>();


    //Add and remove HashSet items
    private void addResidence(ResidenceEntity residence){
        this.residences.add(residence);
    }

    private void removeResidence(ResidenceEntity residence){
        this.residences.remove(residence);
    }


    private void addWorkExperiencie(WorkExperienceEntity workExperience){
        this.workExperiences.add(workExperience);
    }

    private void removeWorkExperience(WorkExperienceEntity workExperience){
        this.workExperiences.remove(workExperience);
    }

    private void addEducation(EducationEntity education){
        this.educations.add(education);
    }

    private void removeEducation(EducationEntity education){
        this.educations.remove(education);
    }

    private void addTechnology(TechnologyEntity technology){
        this.technologies.add(technology);
    }

    private void removeTechnology(TechnologyEntity technology){
        this.technologies.remove(technology);
    }

    private void addProject(ProjectEntity project){
        this.projects.add(project);
    }

    private void removeProject(ProjectEntity project){
        this.projects.remove(project);
    }

    private void addLanguage(LanguageEntity language){
        this.languages.add(language);
    }

    private void removeLanguage(LanguageEntity language){
        this.languages.remove(language);
    }

}
