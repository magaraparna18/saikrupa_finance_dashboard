package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="AdminTable")
public class Admin {
@Id
private int id;
private String adminLogin;
private String dashboard;
private String registerstaff;
private String registerclient;
private String allocatestaffagainstResisterclient;
private String createStatusMaster;
private String clientlist;
private String stafflogin;
private String updateclientstatus;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAdminLogin() {
	return adminLogin;
}
public void setAdminLogin(String adminLogin) {
	this.adminLogin = adminLogin;
}
public String getDashboard() {
	return dashboard;
}
public void setDashboard(String dashboard) {
	this.dashboard = dashboard;
}
public String getRegisterstaff() {
	return registerstaff;
}
public void setRegisterstaff(String registerstaff) {
	this.registerstaff = registerstaff;
}
public String getRegisterclient() {
	return registerclient;
}
public void setRegisterclient(String registerclient) {
	this.registerclient = registerclient;
}
public String getAllocatestaffagainstResisterclient() {
	return allocatestaffagainstResisterclient;
}
public void setAllocatestaffagainstResisterclient(String allocatestaffagainstResisterclient) {
	this.allocatestaffagainstResisterclient = allocatestaffagainstResisterclient;
}
public String getCreateStatusMaster() {
	return createStatusMaster;
}
public void setCreateStatusMaster(String createStatusMaster) {
	this.createStatusMaster = createStatusMaster;
}
public String getClientlist() {
	return clientlist;
}
public void setClientlist(String clientlist) {
	this.clientlist = clientlist;
}
public String getStafflogin() {
	return stafflogin;
}
public void setStafflogin(String stafflogin) {
	this.stafflogin = stafflogin;
}
public String getUpdateclientstatus() {
	return updateclientstatus;
}
public void setUpdateclientstatus(String updateclientstatus) {
	this.updateclientstatus = updateclientstatus;
}
}