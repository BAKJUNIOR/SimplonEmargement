package com.sati.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.sati.model.Participer;
import com.sati.service.Iservice;

import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import antlr.collections.List;

@Component
@Scope("session")
public class ParticipantControllers {

	@Autowired
	Iservice service ;
	private Participer participer = new Participer();
	
	
	private java.util.List<Participer> listTable = new ArrayList<Participer>();
	private Participer selectedParticiper = new Participer();
	
	
	private CommandButton enregistrerBtn = new CommandButton();
	private CommandButton annulerBtn = new CommandButton();
	private CommandButton modifierBtn = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		modifierBtn.setDisabled(true);
	}
	
	
	public void info(String monMessage) {
		FacesContext.getCurrentInstance().addMessage((String) null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, monMessage ,null ));
	}
	
	public void enregistrer() {
		//pousser en base de donnéees
		this.service.addObject(participer);
		this.info("Enregistrement effectuée avec succès......!");
		this.annuler();
	}
	
	public void supprimer() {
		this.service.deleteObject(participer);
		this.annuler();
	}
	
	public void annuler() {
		this.participer.setNomParticipant(null);;
		this.enregistrerBtn.setDisabled(true);
		this.modifierBtn.setDisabled(false);
	}
	
	public void modifier() {
		this.service.addObject(participer);
		this.info("Modification effectuée avec succès!");
		this.annuler();
	}
	
	
	
	public void selectionnerLigne() {
		setSelectedParticiper(selectedParticiper);
		this.enregistrerBtn.setDisabled(true);
		this.modifierBtn.setDisabled(false);
	}
	
	
	
	
	//getter & setter
	public Participer getParticiper() {
		return participer;
		
	}
	
	
	public void setListTable(ArrayList<Participer> listTable) {
		this.listTable = listTable;
		
	}
	public Participer getSelectedParticiper() {
		return selectedParticiper;
		
	}
	public void setSelectedParticiper(Participer selectedParticiper) {
		this.selectedParticiper = selectedParticiper;
		
	}
	public CommandButton getEnregistrerBtn() {
		return enregistrerBtn;
		
	}
	public void setEnregistrerBtn(CommandButton enregistrerBtn) {
		this.enregistrerBtn = enregistrerBtn;
		
	}
	public CommandButton getAnnulerBtn() {
		return annulerBtn;
		
	}
	public void setAnnulerBtn(CommandButton annulerBtn) {
		this.annulerBtn = annulerBtn;
		
	}
	public CommandButton getModifierBtn() {
		return modifierBtn;
		
	}
	public void setModifierBtn(CommandButton modifierBtn) {
		this.modifierBtn = modifierBtn;
		
	}

	@SuppressWarnings("unchecked")
	public java.util.List<Participer> getListTable() {
		listTable = service.getObjects("Participer");
		System.out.println("=================Taille de laliste: "+listTable.size());
		return listTable;
		
	}


	public void setListTable(java.util.List<Participer> listTable) {
		this.listTable = listTable;
		
	}
	
}
