package view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.Controller;
import controller.LogInInterface;
import model.Account;
import model.Consultation;
import model.Doctor;
import model.MyDate;
import model.Patient;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class AdminView extends javax.swing.JFrame implements LogInInterface, ActionListener, ListSelectionListener{

    /**
     * Creates new form DoctorView
     */
	private DefaultTableModel modelDoctors = new DefaultTableModel();
	private DefaultTableModel modelPatients = new DefaultTableModel();
	private Controller controller;
//	public static void main(String[] args)
//	{
//		AdminView v = new AdminView();
//		v.start();
//	}
	public void start()
	{
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	}
    public AdminView() {
    	controller = Controller.getInstance();
    	createComponents();
        initComponents();
        addComponentsToFrame();
        modelDoctors.setColumnIdentifiers(new String[] {"Name","CPR","Office","Office Phone Number"});
        modelPatients.setColumnIdentifiers(new String[] {"Name","CPR","Sex","Phone Number"});
        TableDoctors.setModel(modelDoctors);
        TablePatients.setModel(modelPatients);
        TableDoctors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TablePatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableDoctors.setDefaultEditor(Object.class, null);
        TablePatients.setDefaultEditor(Object.class, null);
        LoadDoctors();
        LoadPatients();
    }
    public void createComponents()
    {
    	HeaderPanel = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        LabelLogoInfo = new javax.swing.JLabel();
        LabelButtonDoctors = new javax.swing.JLabel();
        LabelButtonPersonalInfo = new javax.swing.JLabel();
        LabelLoggedInAs = new javax.swing.JLabel();
        LabelDoctorNameLogIn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        DoctorsPanel = new javax.swing.JPanel();
        ScrollPanelTableDoctors = new javax.swing.JScrollPane();
        TableDoctors = new javax.swing.JTable();
        LabelDoctors = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelDoctorHeader = new javax.swing.JLabel();
        LabelDoctorHeaderInfo = new javax.swing.JLabel();
        LabelDoctorName = new javax.swing.JLabel();
        TextFieldDoctorName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        LabelDoctorAddress = new javax.swing.JLabel();
        TextFieldDoctorAddress = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        LabelDoctorPhone = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        TextFieldDoctorPhone = new javax.swing.JTextField();
        LabelDoctorEmail = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        TextFieldDoctorEmail = new javax.swing.JTextField();
        LabelDoctorBirthday = new javax.swing.JLabel();
        TextFieldDoctorBirthday = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        LabelDoctorOffice = new javax.swing.JLabel();
        TextFieldDoctorOffice = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        LabelDoctorOfficePhone = new javax.swing.JLabel();
        TextFieldDoctorOfficePhone = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        LabelDoctorSpeciality = new javax.swing.JLabel();
        TextFieldDoctorSpeciality = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        ButtonDoctorAdd = new javax.swing.JButton();
        ButtonDoctorSave = new javax.swing.JButton();
        ButtonDoctorRemove = new javax.swing.JButton();
        LabelDoctorPassword = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        PasswordFieldDoctorPassword = new javax.swing.JPasswordField();
        LabelDoctorCPR = new javax.swing.JLabel();
        TextFieldDoctorCPR = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        PatientsPanel = new javax.swing.JPanel();
        LabelPatients = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        ScrollPanelTablePatients = new javax.swing.JScrollPane();
        TablePatients = new javax.swing.JTable();
        LabelPatientHeader = new javax.swing.JLabel();
        LabelPatientHeaderInfo = new javax.swing.JLabel();
        TextFieldPatientName = new javax.swing.JTextField();
        LabelPatientName = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        TextFieldPatientAddress = new javax.swing.JTextField();
        TextFieldPatientPhone = new javax.swing.JTextField();
        TextFieldPatientEmail = new javax.swing.JTextField();
        TextFieldPatientBirthday = new javax.swing.JTextField();
        TextFieldPatientSex = new javax.swing.JTextField();
        TextFieldPatientBlood = new javax.swing.JTextField();
        PasswordFieldPatientPassword = new javax.swing.JPasswordField();
        LabelPatientAddress = new javax.swing.JLabel();
        LabelPatientPhone = new javax.swing.JLabel();
        LabelPatientEmail = new javax.swing.JLabel();
        LabelPatientBirthday = new javax.swing.JLabel();
        LabelPatientSex = new javax.swing.JLabel();
        LabelPatientBlood = new javax.swing.JLabel();
        LabelPatientPassword = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        ButtonPatientAdd = new javax.swing.JButton();
        ButtonPatientSave = new javax.swing.JButton();
        ButtonPatientRemove = new javax.swing.JButton();
        LabelPatientCPR = new javax.swing.JLabel();
        TextFieldPatientCPR = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
    }
    public void addComponentsToFrame()
    {
    	javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(481, 481, 481)
                .addComponent(LabelButtonDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelButtonPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLogo)
                    .addComponent(LabelLogoInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLoggedInAs, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelDoctorNameLogIn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(44, 44, 44))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LabelLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelLogoInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelButtonDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelButtonPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addComponent(LabelLoggedInAs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelDoctorNameLogIn)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout DoctorsPanelLayout = new javax.swing.GroupLayout(DoctorsPanel);
        DoctorsPanel.setLayout(DoctorsPanelLayout);
        DoctorsPanelLayout.setHorizontalGroup(
            DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorsPanelLayout.createSequentialGroup()
                .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(LabelDoctors))
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollPanelTableDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelDoctorHeaderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelDoctorHeader)
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addComponent(ButtonDoctorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonDoctorSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonDoctorRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PasswordFieldDoctorPassword))
                        .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorSpeciality))
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorOfficePhone))
                        .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorOffice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorOffice))
                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorBirthday))
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorEmail))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorPhone))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorAddress))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsPanelLayout.createSequentialGroup()
                            .addComponent(LabelDoctorCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextFieldDoctorCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        DoctorsPanelLayout.setVerticalGroup(
            DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorsPanelLayout.createSequentialGroup()
                .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addComponent(LabelDoctors)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelDoctorHeader)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanelTableDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DoctorsPanelLayout.createSequentialGroup()
                        .addComponent(LabelDoctorHeaderInfo)
                        .addGap(22, 22, 22)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorCPR)
                            .addComponent(TextFieldDoctorCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorName)
                            .addComponent(TextFieldDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorAddress)
                            .addComponent(TextFieldDoctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorPhone)
                            .addComponent(TextFieldDoctorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorEmail)
                            .addComponent(TextFieldDoctorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorBirthday)
                            .addComponent(TextFieldDoctorBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorOffice)
                            .addComponent(TextFieldDoctorOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorOfficePhone)
                            .addComponent(TextFieldDoctorOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorSpeciality)
                            .addComponent(TextFieldDoctorSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorPassword)
                            .addComponent(PasswordFieldDoctorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonDoctorAdd)
                            .addComponent(ButtonDoctorSave)
                            .addComponent(ButtonDoctorRemove))))
                .addContainerGap())
        );
        javax.swing.GroupLayout PatientsPanelLayout = new javax.swing.GroupLayout(PatientsPanel);
        PatientsPanel.setLayout(PatientsPanelLayout);
        PatientsPanelLayout.setHorizontalGroup(
            PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientsPanelLayout.createSequentialGroup()
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(LabelPatients))
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollPanelTablePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85)
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelPatientHeaderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPatientHeader)
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addComponent(ButtonPatientAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonPatientSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonPatientRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PasswordFieldPatientPassword))
                            .addComponent(jSeparator28, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientBlood))
                            .addComponent(jSeparator26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientSex, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientSex))
                            .addComponent(jSeparator25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientBirthday))
                            .addComponent(jSeparator24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientEmail))
                            .addComponent(jSeparator23, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientPhone))
                            .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientAddress))
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                .addComponent(LabelPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        PatientsPanelLayout.setVerticalGroup(
            PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientsPanelLayout.createSequentialGroup()
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addComponent(LabelPatients)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelPatientHeader)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanelTablePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addComponent(LabelPatientHeaderInfo)
                        .addGap(27, 27, 27)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientCPR)
                            .addComponent(TextFieldPatientCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientName)
                            .addComponent(TextFieldPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientAddress)
                            .addComponent(TextFieldPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientPhone)
                            .addComponent(TextFieldPatientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientEmail)
                            .addComponent(TextFieldPatientEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientBirthday)
                            .addComponent(TextFieldPatientBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientSex)
                            .addComponent(TextFieldPatientSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientBlood)
                            .addComponent(TextFieldPatientBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientPassword)
                            .addComponent(PasswordFieldPatientPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonPatientAdd)
                            .addComponent(ButtonPatientSave)
                            .addComponent(ButtonPatientRemove))))
                .addContainerGap())
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HeaderPanel.setBackground(new java.awt.Color(34, 58, 96));

        LabelLogo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        LabelLogo.setForeground(new java.awt.Color(240, 240, 240));
        LabelLogo.setText("iHealth");

        LabelLogoInfo.setForeground(new java.awt.Color(240, 240, 240));
        LabelLogoInfo.setText("Medical solutions for doctors in need.");

        LabelButtonDoctors.setBackground(new java.awt.Color(66, 134, 244));
        LabelButtonDoctors.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelButtonDoctors.setForeground(new java.awt.Color(240, 240, 240));
        LabelButtonDoctors.setText("     Doctors");
        LabelButtonDoctors.setOpaque(true);
        LabelButtonDoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelButtonDoctorsMouseClicked(evt);
            }
        });

        LabelButtonPersonalInfo.setBackground(new java.awt.Color(34, 58, 96));
        LabelButtonPersonalInfo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelButtonPersonalInfo.setForeground(new java.awt.Color(240, 240, 240));
        LabelButtonPersonalInfo.setText("     Patients");
        LabelButtonPersonalInfo.setOpaque(true);
        LabelButtonPersonalInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelButtonPersonalInfoMouseClicked(evt);
            }
        });

        LabelLoggedInAs.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LabelLoggedInAs.setForeground(new java.awt.Color(240, 240, 240));
        LabelLoggedInAs.setText("Logged in as");

        LabelDoctorNameLogIn.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        LabelDoctorNameLogIn.setForeground(new java.awt.Color(240, 240, 240));
        LabelDoctorNameLogIn.setText("ADMINISTRATOR");

        jLabel1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/medicallogo.png")));
        jLabel1.setText("jLabel1");


        MainPanel.setLayout(new java.awt.CardLayout());

        ScrollPanelTableDoctors.setViewportView(TableDoctors);

        LabelDoctors.setText("Doctors");

        LabelDoctorHeader.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelDoctorHeader.setText("Manage Doctor Information");

        LabelDoctorHeaderInfo.setText("Add or Remove a current doctor from the table or update their information.");

        LabelDoctorName.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorName.setText("Name");

        LabelDoctorAddress.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorAddress.setText("Address");

        LabelDoctorPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorPhone.setText("Phone Number");

        LabelDoctorEmail.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorEmail.setText("Email");

        LabelDoctorBirthday.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorBirthday.setText("Birthday");

        LabelDoctorOffice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorOffice.setText("Office");

        LabelDoctorOfficePhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorOfficePhone.setText("Office Phone Number");

        LabelDoctorSpeciality.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorSpeciality.setText("Speciality");

        ButtonDoctorAdd.setText("Add");
        ButtonDoctorAdd.addActionListener(this);

        ButtonDoctorSave.setText("Save");
        ButtonDoctorSave.addActionListener(this);

        ButtonDoctorRemove.setText("Remove");
        ButtonDoctorRemove.addActionListener(this);

        LabelDoctorPassword.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorPassword.setText("Password");

        LabelDoctorCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelDoctorCPR.setText("CPR");


        MainPanel.add(DoctorsPanel, "card2");

        LabelPatients.setText("Patients");

        ScrollPanelTablePatients.setViewportView(TablePatients);

        LabelPatientHeader.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelPatientHeader.setText("Manage Patient Information");

        LabelPatientHeaderInfo.setText("Add or Remove a current patient from the table or update their information.");

        LabelPatientName.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientName.setText("Name");

        LabelPatientAddress.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientAddress.setText("Address");

        LabelPatientPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientPhone.setText("Phone Number");

        LabelPatientEmail.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientEmail.setText("Email");

        LabelPatientBirthday.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientBirthday.setText("Birthday");

        LabelPatientSex.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientSex.setText("Sex");

        LabelPatientBlood.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientBlood.setText("Blood Type");

        LabelPatientPassword.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientPassword.setText("Password");

        ButtonPatientAdd.setText("Add");
        ButtonPatientAdd.addActionListener(this);

        ButtonPatientSave.setText("Save");
        ButtonPatientSave.addActionListener(this);

        ButtonPatientRemove.setText("Remove");
        ButtonPatientRemove.addActionListener(this);

        LabelPatientCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPatientCPR.setText("CPR");

        TableDoctors.getSelectionModel().addListSelectionListener(this);
        TablePatients.getSelectionModel().addListSelectionListener(this);
        
        MainPanel.add(PatientsPanel, "card4");

    }// </editor-fold>//GEN-END:initComponents
    
    private void LabelButtonDoctorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonDoctorsMouseClicked
        setLabelColor(LabelButtonDoctors);
        resetLabelColor(LabelButtonPersonalInfo);
        DoctorsPanel.setVisible(true);
        PatientsPanel.setVisible(false);
    }//GEN-LAST:event_LabelButtonDoctorsMouseClicked

    private void LabelButtonPersonalInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonPersonalInfoMouseClicked
        setLabelColor(LabelButtonPersonalInfo);
        resetLabelColor(LabelButtonDoctors);
        DoctorsPanel.setVisible(false);
        PatientsPanel.setVisible(true);
    }//GEN-LAST:event_LabelButtonPersonalInfoMouseClicked
    private void setLabelColor(JLabel label)
    {
        label.setBackground(new Color(66, 134, 244));
    }
    private void resetLabelColor(JLabel label)
    {
        label.setBackground(new Color(34,58,96));
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDoctorAdd;
    private javax.swing.JButton ButtonDoctorRemove;
    private javax.swing.JButton ButtonDoctorSave;
    private javax.swing.JButton ButtonPatientAdd;
    private javax.swing.JButton ButtonPatientRemove;
    private javax.swing.JButton ButtonPatientSave;
    private javax.swing.JPanel DoctorsPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel LabelButtonDoctors;
    private javax.swing.JLabel LabelButtonPersonalInfo;
    private javax.swing.JLabel LabelDoctorAddress;
    private javax.swing.JLabel LabelDoctorBirthday;
    private javax.swing.JLabel LabelDoctorCPR;
    private javax.swing.JLabel LabelDoctorEmail;
    private javax.swing.JLabel LabelDoctorHeader;
    private javax.swing.JLabel LabelDoctorHeaderInfo;
    private javax.swing.JLabel LabelDoctorName;
    private javax.swing.JLabel LabelDoctorNameLogIn;
    private javax.swing.JLabel LabelDoctorOffice;
    private javax.swing.JLabel LabelDoctorOfficePhone;
    private javax.swing.JLabel LabelDoctorPassword;
    private javax.swing.JLabel LabelDoctorPhone;
    private javax.swing.JLabel LabelDoctorSpeciality;
    private javax.swing.JLabel LabelDoctors;
    private javax.swing.JLabel LabelLoggedInAs;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogoInfo;
    private javax.swing.JLabel LabelPatientAddress;
    private javax.swing.JLabel LabelPatientBirthday;
    private javax.swing.JLabel LabelPatientBlood;
    private javax.swing.JLabel LabelPatientCPR;
    private javax.swing.JLabel LabelPatientEmail;
    private javax.swing.JLabel LabelPatientHeader;
    private javax.swing.JLabel LabelPatientHeaderInfo;
    private javax.swing.JLabel LabelPatientName;
    private javax.swing.JLabel LabelPatientPassword;
    private javax.swing.JLabel LabelPatientPhone;
    private javax.swing.JLabel LabelPatientSex;
    private javax.swing.JLabel LabelPatients;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPasswordField PasswordFieldDoctorPassword;
    private javax.swing.JPasswordField PasswordFieldPatientPassword;
    private javax.swing.JPanel PatientsPanel;
    private javax.swing.JScrollPane ScrollPanelTableDoctors;
    private javax.swing.JScrollPane ScrollPanelTablePatients;
    private javax.swing.JTable TableDoctors;
    private javax.swing.JTable TablePatients;
    private javax.swing.JTextField TextFieldDoctorAddress;
    private javax.swing.JTextField TextFieldDoctorBirthday;
    private javax.swing.JTextField TextFieldDoctorCPR;
    private javax.swing.JTextField TextFieldDoctorEmail;
    private javax.swing.JTextField TextFieldDoctorName;
    private javax.swing.JTextField TextFieldDoctorOffice;
    private javax.swing.JTextField TextFieldDoctorOfficePhone;
    private javax.swing.JTextField TextFieldDoctorPhone;
    private javax.swing.JTextField TextFieldDoctorSpeciality;
    private javax.swing.JTextField TextFieldPatientAddress;
    private javax.swing.JTextField TextFieldPatientBirthday;
    private javax.swing.JTextField TextFieldPatientBlood;
    private javax.swing.JTextField TextFieldPatientCPR;
    private javax.swing.JTextField TextFieldPatientEmail;
    private javax.swing.JTextField TextFieldPatientName;
    private javax.swing.JTextField TextFieldPatientPhone;
    private javax.swing.JTextField TextFieldPatientSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
    private void emptyTableDoctors()
    {
//    	while(modelDoctors.getRowCount() > 1)
//    	{
//    		modelDoctors.removeRow(0);
//    	}
    	modelDoctors.setRowCount(0);
    }
    private void emptyTablePatients()
    {
//    	while(modelDoctors.getRowCount() > 1)
//    	{
//    		modelDoctors.removeRow(0);
//    	}
    	modelPatients.setRowCount(0);
    }
    private void LoadDoctors()
    {
    	//modelDoctors.setRowCount(0);
    	ArrayList<Doctor> doctors = controller.getAllDoctors();
    	for(int i = 0; i < doctors.size(); i++)
    	{
    		modelDoctors.addRow(new String[] {doctors.get(i).getName(),doctors.get(i).getCPR(),doctors.get(i).getOffice(),doctors.get(i).getOfficePhoneNumber()});
    	}
    }
    private void LoadPatients()
    {
    	ArrayList<Patient> patients = controller.getAllPatients();
    	for(int i = 0; i < patients.size(); i++)
    	{
    		modelPatients.addRow(new String[] {patients.get(i).getName(),patients.get(i).getCPR(),patients.get(i).getSex()+"",patients.get(i).getPhoneNumber()});
    	}
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource() == ButtonDoctorAdd)
    	{
    		try
    		{
    			String cpr = TextFieldDoctorCPR.getText();
    			if(cpr.length() == 10)
    			{
    				Doctor doctor = controller.getDoctorByCpr(cpr);
    				if(doctor == null)
    				{
    					MyDate birthday;
    	    			String[] date = TextFieldDoctorBirthday.getText().split("/");
    	    			if(Integer.parseInt(date[2]) > 1800 && Integer.parseInt(date[1]) > 0 && Integer.parseInt(date[1]) < 13)
    	    			{
    	    				birthday = new MyDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
	    					doctor = new Doctor();
	    					doctor.setCPR(cpr)
	    					.setName(TextFieldDoctorName.getText())
	    					.setBirthday(birthday)
	    					.setAddress(TextFieldDoctorAddress.getText())
	    					.setEmail(TextFieldDoctorEmail.getText())
	    					.setPhoneNumber(TextFieldDoctorPhone.getText())
	    					.setOffice(TextFieldDoctorOffice.getText())
	    					.setOfficePhoneNumber(TextFieldDoctorOfficePhone.getText())
	    					.setSpeciality(TextFieldDoctorSpeciality.getText());
	    					controller.addDoctor(doctor, PasswordFieldDoctorPassword.getText());
    	    			}
    				}
    			}
    			try
        		{
        			TableDoctors.getSelectionModel().clearSelection();
    	    		modelDoctors.fireTableDataChanged();
        		}
        		catch(Exception e1){}
        		try{
        			emptyTableDoctors();
    	    		LoadDoctors();
        		}catch(Exception e1){}
    		}
    		catch(Exception ex){}
    	}
    	else if(e.getSource() == ButtonDoctorSave)
    	{
    		try
    		{
	    		if(TableDoctors.getSelectedRow() >= 0)
	    		{
	    			Doctor doctor = controller.getDoctorByIndex(TableDoctors.getSelectedRow());
	    			MyDate birthday;
	    			String[] date = TextFieldDoctorBirthday.getText().split("/");
	    			if(Integer.parseInt(date[2]) > 1800 && Integer.parseInt(date[1]) > 0 && Integer.parseInt(date[1]) < 13)
	    			{
		    			birthday = new MyDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
			    		doctor.setName(TextFieldDoctorName.getText())
			    		.setAddress(TextFieldDoctorAddress.getText())
			    		.setBirthday(birthday)
			    		.setEmail(TextFieldDoctorEmail.getText())
			    		.setPhoneNumber(TextFieldDoctorPhone.getText())
			    		.setOffice(TextFieldDoctorOffice.getText())
			    		.setOfficePhoneNumber(TextFieldDoctorOfficePhone.getText())
			    		.setSpeciality(TextFieldDoctorSpeciality.getText());
			    		controller.updateDoctor(doctor);
	    			}
	    		}
	    		try
	    		{
	    			TableDoctors.getSelectionModel().clearSelection();
		    		modelDoctors.fireTableDataChanged();
	    		}
	    		catch(Exception e1){}
	    		try{
	    			emptyTableDoctors();
		    		LoadDoctors();
	    		}catch(Exception e1){}
    		}
    		catch(Exception ex){}
    	}
    	else if(e.getSource() == ButtonDoctorRemove)
    	{
    		try
    		{
	    		if(TableDoctors.getSelectedRow() >= 0)
	    		{
	    			Doctor doctor = controller.getDoctorByIndex(TableDoctors.getSelectedRow());
	    			ArrayList<Consultation> consultations = controller.getAllConsultations();
	    			for(int i = 0; i < consultations.size(); i++)
	    			{
	    				if(consultations.get(i).getDoctorCPR().equals(doctor.getCPR()))
	    				{
	    					controller.removeConsultation(consultations.get(i).getId());
	    				}
	    			}
	    			controller.removeDoctor(doctor.getCPR());
	    		}
	    		try
	    		{
	    			TableDoctors.getSelectionModel().clearSelection();
		    		modelDoctors.fireTableDataChanged();
	    		}
	    		catch(Exception e1){}
	    		try{
	    			emptyTableDoctors();
		    		LoadDoctors();
	    		}catch(Exception e1){}
    		}
    		catch(Exception ex){}
    	}
    	else if(e.getSource() == ButtonPatientAdd)
    	{
    		try
    		{
    			String cpr = TextFieldPatientCPR.getText();
    			if(cpr.length() == 10)
    			{
    				Patient patient = controller.getPatientByCprFromModel(cpr);
    				if(patient == null)
    				{
    					MyDate birthday;
    	    			String[] date = TextFieldPatientBirthday.getText().split("/");
    	    			if(Integer.parseInt(date[2]) > 1800 && Integer.parseInt(date[1]) > 0 && Integer.parseInt(date[1]) < 13)
    	    			{
    	    				birthday = new MyDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
	    					patient = new Patient();
	    					patient.setCPR(cpr)
	    					.setName(TextFieldPatientName.getText())
	    					.setBirthday(birthday)
	    					.setAddress(TextFieldPatientAddress.getText())
	    					.setEmail(TextFieldPatientEmail.getText())
	    					.setPhoneNumber(TextFieldPatientPhone.getText())
	    					.setBloodType(TextFieldPatientBlood.getText())
	    					.setSex(TextFieldPatientSex.getText().charAt(0));
	    					
	    					controller.addPatient(patient, PasswordFieldPatientPassword.getText());
    	    			}
    				}
    			}
    			try
	    		{
	    			TablePatients.getSelectionModel().clearSelection();
		    		modelPatients.fireTableDataChanged();
	    		}
	    		catch(Exception e1){}
	    		try{
	    			emptyTablePatients();
		    		LoadPatients();
	    		}catch(Exception e1){}
    		}
    		catch(Exception ex){}
    	}
    	else if(e.getSource() == ButtonPatientSave)
    	{
    		try
    		{
	    		if(TablePatients.getSelectedRow() >= 0)
	    		{
	
	    			//String cpr = controller.getPatientByIndex(TablePatients.getSelectedRow()).getCPR();
	    			Patient patient = controller.getPatientByIndex(TablePatients.getSelectedRow());
	    			MyDate birthday;
	    			String[] date = TextFieldPatientBirthday.getText().split("/");
	    			if(Integer.parseInt(date[2]) > 1800 && Integer.parseInt(date[1]) > 0 && Integer.parseInt(date[1]) < 13)
	    			{
		    			birthday = new MyDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
		    			if(TextFieldPatientSex.getText().charAt(0) == 'M' || TextFieldPatientSex.getText().charAt(0) == 'F')
		    			{
			    			patient.setName(TextFieldPatientName.getText())
			    			.setCPR(TextFieldPatientCPR.getText())
			    			.setAddress(TextFieldPatientAddress.getText())
			    			.setBirthday(birthday)
			    			.setBloodType(TextFieldPatientBlood.getText())
			    			.setEmail(TextFieldPatientEmail.getText())
			    			.setPhoneNumber(TextFieldPatientPhone.getText())
			    			.setSex(TextFieldPatientSex.getText().charAt(0));
			    			controller.updatePatient(patient);
		    			}
	    			}
	    		}
	    		try
	    		{
	    			TablePatients.getSelectionModel().clearSelection();
		    		modelPatients.fireTableDataChanged();
	    		}
	    		catch(Exception e1){}
	    		try{
	    			emptyTablePatients();
		    		LoadPatients();
	    		}catch(Exception e1){}
    		}
    		catch(Exception ex){}
    	}
    	else if(e.getSource() == ButtonPatientRemove)
    	{
    		try
    		{
	    		if(TablePatients.getSelectedRow() >= 0)
	    		{
	    			Patient patient = controller.getPatientByIndex(TablePatients.getSelectedRow());
	    			ArrayList<Consultation> consultations = controller.getAllConsultations();
	    			for(int i = 0; i < consultations.size(); i++)
	    			{
	    				if(consultations.get(i).getPatientCPR().equals(patient.getCPR()))
	    				{
	    					controller.removeConsultation(consultations.get(i).getId());
	    				}
	    			}
	    			controller.removePatient(patient.getCPR());
	    		}
	    		try
	    		{
	    			TablePatients.getSelectionModel().clearSelection();
		    		modelPatients.fireTableDataChanged();
	    		}
	    		catch(Exception e1){}
	    		try{
	    			emptyTablePatients();
		    		LoadPatients();
	    		}catch(Exception e1){}
    		}
    		catch(Exception ex){}
    	}
    }
	public void valueChanged(ListSelectionEvent e) 
	{
		if(e.getSource() == TableDoctors.getSelectionModel())
		{
			if(TableDoctors.getSelectedRow() != -1)
			{
				String cpr = controller.getDoctorByIndex(TableDoctors.getSelectedRow()).getCPR();
				Doctor doctor = controller.getDoctorByCpr(cpr);
				TextFieldDoctorName.setText(doctor.getName());
				TextFieldDoctorCPR.setText(doctor.getCPR());
				TextFieldDoctorAddress.setText(doctor.getAddress());
				PasswordFieldDoctorPassword.setText("");
				TextFieldDoctorEmail.setText(doctor.getEmail());
				TextFieldDoctorPhone.setText(doctor.getPhoneNumber());
				TextFieldDoctorBirthday.setText(doctor.getBirthday().toString());
				TextFieldDoctorSpeciality.setText(doctor.getSpeciality());
				TextFieldDoctorOffice.setText(doctor.getOffice());
				TextFieldDoctorOfficePhone.setText(doctor.getOfficePhoneNumber());
			}
			
		}
		else if(e.getSource() == TablePatients.getSelectionModel())
		{
			if(TablePatients.getSelectedRow() != -1)
			{
				String cpr = controller.getPatientByIndex(TablePatients.getSelectedRow()).getCPR();
				Patient patient = controller.getPatientByCprFromModel(cpr);
				TextFieldPatientName.setText(patient.getName());
				TextFieldPatientCPR.setText(patient.getCPR());
				PasswordFieldPatientPassword.setText("");
				TextFieldPatientAddress.setText(patient.getAddress());
				TextFieldPatientEmail.setText(patient.getEmail());
				TextFieldPatientPhone.setText(patient.getPhoneNumber());
				TextFieldPatientBirthday.setText(patient.getBirthday().toString());
				TextFieldPatientSex.setText(patient.getSex()+"");
				TextFieldPatientBlood.setText(patient.getBloodType());
			}
		}
		
	}
}
