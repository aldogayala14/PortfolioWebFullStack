package com.argprog.portfolio.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "persons")
@Getter
@Setter
@SQLDelete(sql = "UPDATE persons SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
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

    @ManyToOne
    @JoinColumn(name = "residence_id", insertable = false,updatable = false)
    private ResidenceEntity residence;

    @Column(name = "residence_id", nullable = false)
    private Long residenceId;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "experience_person",
            joinColumns = @JoinColumn (name = "person_id"),
            inverseJoinColumns =@JoinColumn(name = "experiencie_id"))
    private List<WorkExperienceEntity> workExperiences = new ArrayList<>();



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "education_person",
            joinColumns = @JoinColumn (name = "person_id"),
            inverseJoinColumns =@JoinColumn(name = "education_id"))
    private List<EducationEntity> educations = new ArrayList<>();



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "project_person",
            joinColumns = @JoinColumn (name = "person_id"),
            inverseJoinColumns =@JoinColumn(name = "project_id"))
    private List<ProjectEntity> projects = new ArrayList<>();


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "technology_person",
            joinColumns = @JoinColumn (name = "person_id"),
            inverseJoinColumns =@JoinColumn(name = "technology_id"))
    private List<TechnologyEntity> technologies = new ArrayList<>();



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "language_person",
            joinColumns = @JoinColumn (name = "person_id"),
            inverseJoinColumns =@JoinColumn(name = "language_id"))
    private List<LanguageEntity> languages = new ArrayList<>();


    private boolean deleted = Boolean.FALSE;


    //Add and remove List items
    public void addWorkExperiencie(WorkExperienceEntity workExperience){
        this.workExperiences.add(workExperience);
    }

    public void removeWorkExperience(WorkExperienceEntity workExperience){
        this.workExperiences.remove(workExperience);
    }

    public void addEducation(EducationEntity education){
        this.educations.add(education);
    }

    public void removeEducation(EducationEntity education){
        this.educations.remove(education);
    }

    public void addTechnology(TechnologyEntity technology){
        this.technologies.add(technology);
    }

    public void removeTechnology(TechnologyEntity technology){
        this.technologies.remove(technology);
    }

    public void addProject(ProjectEntity project){
        this.projects.add(project);
    }

    public void removeProject(ProjectEntity project){
        this.projects.remove(project);
    }

    public void addLanguage(LanguageEntity language){
        this.languages.add(language);
    }

    public void removeLanguage(LanguageEntity language){
        this.languages.remove(language);
    }

}
