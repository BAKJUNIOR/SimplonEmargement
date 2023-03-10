package com.sati.model;
// Generated 22 janv. 2023 � 03:52:28 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "utilisateur", catalog = "emargementsimplon_bd")
public class Utilisateur implements java.io.Serializable {

	private Integer idUser;
	private String nom;
	private String mdp;
	private Set<Participer> participers = new HashSet<Participer>(0);

	public Utilisateur() {
	}

	public Utilisateur(String nom, String mdp) {
		this.nom = nom;
		this.mdp = mdp;
	}

	public Utilisateur(String nom, String mdp, Set<Participer> participers) {
		this.nom = nom;
		this.mdp = mdp;
		this.participers = participers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_USER", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "NOM", nullable = false, length = 65535)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "MDP", nullable = false, length = 65535)
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "faire", catalog = "emargementsimplon_bd", joinColumns = {
			@JoinColumn(name = "ID_USER", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PARTICIPANT", nullable = false, updatable = false) })
	public Set<Participer> getParticipers() {
		return this.participers;
	}

	public void setParticipers(Set<Participer> participers) {
		this.participers = participers;
	}

}
