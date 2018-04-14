package view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Consultation;
import model.ConsultationList;
import model.Doctor;
import model.MyDate;
import model.Patient;
import controller.Controller;
import controller.LogInInterface;

public class DoctorView extends javax.swing.JFrame implements LogInInterface, ListSelectionListener, ActionListener
{
//	public static void main(String[] args)
//	{
//		DoctorView view = new DoctorView();
//		view.start();
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
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	}
    public DoctorView() {
    	controller = Controller.getInstance();
    	createComponents();
        initComponents();
        addComponentsToFrame();
        registerEventHandlers();
    }
    public void addComponentsToFrame()
    {
    	javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(LabelButtonPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelButtonRegisterPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelButtonPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
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
                            .addComponent(LabelButtonPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelButtonRegisterPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelButtonPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HeaderPanelLayout.createSequentialGroup()
                        .addComponent(LabelLoggedInAs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelDoctorNameLogIn)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout PatientsPanelLayout = new javax.swing.GroupLayout(PatientsPanel);
        PatientsPanel.setLayout(PatientsPanelLayout);
        PatientsPanelLayout.setHorizontalGroup(
            PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientsPanelLayout.createSequentialGroup()
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(LabelPatients)
                                .addGap(76, 76, 76))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TextFieldSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonSearch)
                                .addGap(18, 18, 18)))
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonShowAll)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(LabelConsultations)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelNotes)
                                .addGap(197, 197, 197))))
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ScrollPanelTablePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(LabelPatientsInformation))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientsPanelLayout.createSequentialGroup()
                                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator28, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                                .addComponent(LabelPatientInfoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextFieldPatientInfoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                                .addComponent(LabelPatientInfoAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextFieldPatientInfoAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(48, 48, 48))
                                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                                .addComponent(LabelPatientInfoBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextFieldPatientInfoBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                                    .addComponent(LabelPatientInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(TextFieldPatientInfoName))
                                                .addComponent(jSeparator24, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                                    .addComponent(LabelPatientInfoCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(TextFieldPatientInfoCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                                .addComponent(jSeparator25, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientsPanelLayout.createSequentialGroup()
                                                    .addComponent(LabelPatientInfoBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(TextFielPatientInfoBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)))))
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(ScrollPanelListConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(ScrollPanelTextAreaNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE))
                            .addGroup(PatientsPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(ButtonCreateConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonRemoveConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonUpdateConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)))))
                .addGap(20, 20, 20))
        );
        PatientsPanelLayout.setVerticalGroup(
            PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientsPanelLayout.createSequentialGroup()
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPatients)
                    .addComponent(LabelConsultations)
                    .addComponent(LabelNotes))
                .addGap(4, 4, 4)
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPanelListConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrollPanelTextAreaNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonCreateConsultation)
                            .addComponent(ButtonRemoveConsultation)
                            .addComponent(ButtonUpdateConsultation))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PatientsPanelLayout.createSequentialGroup()
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSearch)
                            .addComponent(ButtonShowAll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollPanelTablePatients, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelPatientsInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientInfoCPR)
                            .addComponent(TextFieldPatientInfoCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientInfoName)
                            .addComponent(TextFieldPatientInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientInfoBirthday)
                            .addComponent(TextFielPatientInfoBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientInfoEmail)
                            .addComponent(TextFieldPatientInfoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientInfoBlood)
                            .addComponent(TextFieldPatientInfoBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(PatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPatientInfoAddress)
                            .addComponent(TextFieldPatientInfoAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        javax.swing.GroupLayout RegisterPatientPanelLayout = new javax.swing.GroupLayout(RegisterPatientPanel);
        RegisterPatientPanel.setLayout(RegisterPatientPanelLayout);
        RegisterPatientPanelLayout.setHorizontalGroup(
            RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(ButtonRegisterPatient)
                .addContainerGap(1010, Short.MAX_VALUE))
            .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterBlood)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterSex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterSex, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterBirthday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldRegisterName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterCPR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFielRegisterCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelRegisterPatientInfo)
                    .addComponent(LabelRegisterPatient)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(LabelRegisterPassword)
                        .addGap(63, 63, 63)
                        .addComponent(PasswordFieldRegisterPassword))
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPatientPanelLayout.createSequentialGroup()
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelAddPatientInfo)
                            .addComponent(LabelAddPatient)
                            .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                    .addComponent(LabelAddNewCPR)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldAddNewCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(ButtonAddPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 331, 331))
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelRemovePatientInfo)
                                .addComponent(LabelRemovePatient)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                        .addComponent(LabelRemovePatientCPR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldRemovePatientCPR, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterPatientPanelLayout.createSequentialGroup()
                                .addComponent(ButtonRemovePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175)))
                        .addContainerGap())))
        );
        RegisterPatientPanelLayout.setVerticalGroup(
            RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                        .addComponent(LabelRegisterPatient)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelRegisterPatientInfo))
                                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                        .addComponent(LabelAddPatient)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelAddPatientInfo)))
                                .addGap(43, 43, 43)
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelRegisterCPR)
                                    .addComponent(TextFielRegisterCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelAddNewCPR)
                                    .addComponent(TextFieldAddNewCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelRegisterName)
                            .addComponent(TextFieldRegisterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonAddPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRegisterAddress)
                    .addComponent(TextFieldRegisterAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRegisterEmail)
                    .addComponent(TextFieldRegisterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRegisterPhone)
                    .addComponent(TextFieldRegisterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelRegisterBirthday)
                            .addComponent(TextFieldRegisterBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelRegisterSex)
                            .addComponent(TextFieldRegisterSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelRegisterBlood)
                            .addComponent(TextFieldRegisterBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelRegisterPassword)
                            .addComponent(PasswordFieldRegisterPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                            .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                    .addComponent(LabelRemovePatient)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LabelRemovePatientInfo)
                                    .addGap(79, 79, 79))
                                .addGroup(RegisterPatientPanelLayout.createSequentialGroup()
                                    .addGroup(RegisterPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LabelRemovePatientCPR)
                                        .addComponent(TextFieldRemovePatientCPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(43, 43, 43))
                        .addComponent(ButtonRemovePatient)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(ButtonRegisterPatient)
                .addGap(72, 72, 72))
        );
        javax.swing.GroupLayout PersonalInformationPanelLayout = new javax.swing.GroupLayout(PersonalInformationPanel);
        PersonalInformationPanel.setLayout(PersonalInformationPanelLayout);
        PersonalInformationPanelLayout.setHorizontalGroup(
            PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                    .addComponent(LabelPersonalSpeciality)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldPersonalSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                    .addComponent(LabelPersonalOfficePhone)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldPersonalOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                    .addComponent(LabelPersonalOffice)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldPersonalOffice, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelPersonalBirthday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldPersonalBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelPersonalPhone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldPersonalPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelPersonalEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldPersonalEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelPersonalAddress)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldPersonalAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelPersonalName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldPersonalName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelMyPersonalInfoText)
                                    .addComponent(LabelMyPersonalInfo)))))
                    .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(ButtonUpdatePersonalInfo)))
                .addContainerGap(832, Short.MAX_VALUE))
        );
        PersonalInformationPanelLayout.setVerticalGroup(
            PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(LabelMyPersonalInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelMyPersonalInfoText)
                .addGap(44, 44, 44)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalName)
                    .addComponent(TextFieldPersonalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalAddress)
                    .addComponent(TextFieldPersonalAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalEmail)
                    .addComponent(TextFieldPersonalEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalPhone)
                    .addComponent(TextFieldPersonalPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalBirthday)
                    .addComponent(TextFieldPersonalBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalOffice)
                    .addComponent(TextFieldPersonalOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalOfficePhone)
                    .addComponent(TextFieldPersonalOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalSpeciality)
                    .addComponent(TextFieldPersonalSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonUpdatePersonalInfo)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        MainPanel.add(PersonalInformationPanel, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        requestFocusInWindow();
        
    }
    public void createComponents()
    {
    	HeaderPanel = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        LabelLogoInfo = new javax.swing.JLabel();
        LabelButtonPatients = new javax.swing.JLabel();
        LabelButtonRegisterPatient = new javax.swing.JLabel();
        LabelButtonPersonalInfo = new javax.swing.JLabel();
        LabelLoggedInAs = new javax.swing.JLabel();
        LabelDoctorNameLogIn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        PatientsPanel = new javax.swing.JPanel();
        ScrollPanelTablePatients = new javax.swing.JScrollPane();
        TablePatients = new javax.swing.JTable();
        LabelPatients = new javax.swing.JLabel();
        TextFieldSearchPatient = new javax.swing.JTextField();
        ButtonSearch = new javax.swing.JButton();
        ButtonShowAll = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        LabelConsultations = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ScrollPanelListConsultations = new javax.swing.JScrollPane();
        ListConsultations = new javax.swing.JList<>();
        LabelNotes = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ScrollPanelTextAreaNotes = new javax.swing.JScrollPane();
        TextAreaNotes = new javax.swing.JTextArea();
        LabelPatientsInformation = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        LabelPatientInfoCPR = new javax.swing.JLabel();
        TextFieldPatientInfoCPR = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        LabelPatientInfoName = new javax.swing.JLabel();
        TextFieldPatientInfoName = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        LabelPatientInfoBirthday = new javax.swing.JLabel();
        TextFielPatientInfoBirthday = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        LabelPatientInfoEmail = new javax.swing.JLabel();
        TextFieldPatientInfoEmail = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        LabelPatientInfoBlood = new javax.swing.JLabel();
        TextFieldPatientInfoBlood = new javax.swing.JTextField();
        jSeparator28 = new javax.swing.JSeparator();
        LabelPatientInfoAddress = new javax.swing.JLabel();
        TextFieldPatientInfoAddress = new javax.swing.JTextField();
        ButtonCreateConsultation = new javax.swing.JButton();
        ButtonRemoveConsultation = new javax.swing.JButton();
        ButtonUpdateConsultation = new javax.swing.JButton();
        RegisterPatientPanel = new javax.swing.JPanel();
        LabelRegisterPatient = new javax.swing.JLabel();
        LabelRegisterPatientInfo = new javax.swing.JLabel();
        LabelRegisterCPR = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        TextFielRegisterCPR = new javax.swing.JTextField();
        LabelRegisterName = new javax.swing.JLabel();
        TextFieldRegisterName = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        LabelRegisterAddress = new javax.swing.JLabel();
        TextFieldRegisterAddress = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        LabelRegisterEmail = new javax.swing.JLabel();
        TextFieldRegisterEmail = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        LabelRegisterPhone = new javax.swing.JLabel();
        TextFieldRegisterPhone = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        LabelRegisterBirthday = new javax.swing.JLabel();
        TextFieldRegisterBirthday = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        LabelRegisterSex = new javax.swing.JLabel();
        TextFieldRegisterSex = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        LabelRegisterBlood = new javax.swing.JLabel();
        TextFieldRegisterBlood = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        ButtonRegisterPatient = new javax.swing.JButton();
        LabelRegisterPassword = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        PasswordFieldRegisterPassword = new javax.swing.JPasswordField();
        LabelAddPatient = new javax.swing.JLabel();
        LabelAddPatientInfo = new javax.swing.JLabel();
        LabelAddNewCPR = new javax.swing.JLabel();
        TextFieldAddNewCPR = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        ButtonAddPatient = new javax.swing.JButton();
        LabelRemovePatient = new javax.swing.JLabel();
        LabelRemovePatientInfo = new javax.swing.JLabel();
        LabelRemovePatientCPR = new javax.swing.JLabel();
        TextFieldRemovePatientCPR = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        ButtonRemovePatient = new javax.swing.JButton();
        PersonalInformationPanel = new javax.swing.JPanel();
        LabelMyPersonalInfo = new javax.swing.JLabel();
        LabelMyPersonalInfoText = new javax.swing.JLabel();
        LabelPersonalName = new javax.swing.JLabel();
        TextFieldPersonalName = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        LabelPersonalAddress = new javax.swing.JLabel();
        TextFieldPersonalAddress = new javax.swing.JTextField();
        LabelPersonalEmail = new javax.swing.JLabel();
        TextFieldPersonalEmail = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        LabelPersonalPhone = new javax.swing.JLabel();
        TextFieldPersonalPhone = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        LabelPersonalBirthday = new javax.swing.JLabel();
        TextFieldPersonalBirthday = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        LabelPersonalOffice = new javax.swing.JLabel();
        TextFieldPersonalOffice = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        LabelPersonalOfficePhone = new javax.swing.JLabel();
        TextFieldPersonalOfficePhone = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        LabelPersonalSpeciality = new javax.swing.JLabel();
        TextFieldPersonalSpeciality = new javax.swing.JTextField();
        jSeparator22 = new javax.swing.JSeparator();
        ButtonUpdatePersonalInfo = new javax.swing.JButton();
    }

    private void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextFieldPatientInfoCPR.setEditable(false);
        TextFieldPatientInfoName.setEditable(false);
        TextFieldPatientInfoAddress.setEditable(false);
        TextFieldPatientInfoEmail.setEditable(false);
        TextFielPatientInfoBirthday.setEditable(false);
        TextFieldPatientInfoBlood.setEditable(false);
        //TextFieldPatientInfoCPR.setEditable();
        
        HeaderPanel.setBackground(new java.awt.Color(34, 58, 96));

        LabelLogo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        LabelLogo.setForeground(new java.awt.Color(240, 240, 240));
        LabelLogo.setText("iHealth");

        LabelLogoInfo.setForeground(new java.awt.Color(240, 240, 240));
        LabelLogoInfo.setText("Medical solutions for doctors in need.");

        LabelButtonPatients.setBackground(new java.awt.Color(34, 58, 96));
        LabelButtonPatients.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelButtonPatients.setForeground(new java.awt.Color(240, 240, 240));
        LabelButtonPatients.setText("    Patients");
        LabelButtonPatients.setOpaque(true);
        setLabelColor(LabelButtonPatients);
        LabelButtonPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelButtonPatientsMouseClicked(evt);
            }
        });

        LabelButtonRegisterPatient.setBackground(new java.awt.Color(34, 58, 96));
        LabelButtonRegisterPatient.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelButtonRegisterPatient.setForeground(new java.awt.Color(240, 240, 240));
        LabelButtonRegisterPatient.setText("    Register Patient");
        LabelButtonRegisterPatient.setOpaque(true);
        LabelButtonRegisterPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelButtonRegisterPatientMouseClicked(evt);
            }
        });

        LabelButtonPersonalInfo.setBackground(new java.awt.Color(34, 58, 96));
        LabelButtonPersonalInfo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelButtonPersonalInfo.setForeground(new java.awt.Color(240, 240, 240));
        LabelButtonPersonalInfo.setText("    Personal Information");
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
        LabelDoctorNameLogIn.setText("DOCTOR's NAME HERE");

        jLabel1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/medicallogo.png"))); // NOI18N
        jLabel1.setText("jLabel1");


        MainPanel.setLayout(new java.awt.CardLayout());
        
        patientsModel = new DefaultTableModel();
        patientsModel.addColumn("Name");
        patientsModel.addColumn("CPR");
        patientsModel.addColumn("Phone No");
        patientsModel.addColumn("Sex");
        TablePatients.setModel(patientsModel);
        TablePatients.setDefaultEditor(Object.class, null);
        try
        {
        	addAllPatients();
        }
        catch(Exception e)
        {System.out.println("no patients");}
        try
        {
        	LabelDoctorNameLogIn.setText(controller.getDoctorByIndex(0).getName());
        }
        catch(Exception e)
        {
        }
//        addRow(new Patient().setName("Name").setCPR("1234567890").setPhoneNumber("142342234").setSex('M'));
        TablePatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ScrollPanelTablePatients.setViewportView(TablePatients);

        LabelPatients.setText("Patients");

        TextFieldSearchPatient.setText("Search...");
        TextFieldSearchPatient.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldSearchPatient.getText().equals("Search...")) {
                	TextFieldSearchPatient.setText("");
                	TextFieldSearchPatient.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldSearchPatient.getText().isEmpty()) {
                	TextFieldSearchPatient.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldSearchPatient.setText("Search...");
                }
            }
         });

        ButtonSearch.setText("Search");

        ButtonShowAll.setText("Show All");

        LabelConsultations.setText("Consultations");
        consultationList = new ArrayList<>();
        ListConsultations.setListData(consultationList.toArray());
        ScrollPanelListConsultations.setViewportView(ListConsultations);

        LabelNotes.setText("Notes");

        TextAreaNotes.setColumns(20);
        TextAreaNotes.setRows(5);
        TextAreaNotes.setLineWrap(true);
        TextAreaNotes.setWrapStyleWord(true);
        ScrollPanelTextAreaNotes.setViewportView(TextAreaNotes);

        LabelPatientsInformation.setText("Patient's Information");

        LabelPatientInfoCPR.setText("CPR");

        LabelPatientInfoName.setText("Name");

        LabelPatientInfoBirthday.setText("Birthday");

        LabelPatientInfoEmail.setText("Email");

        LabelPatientInfoBlood.setText("Blood Type");

        LabelPatientInfoAddress.setText("Address");

        ButtonCreateConsultation.setText("Create");

        ButtonRemoveConsultation.setText("Remove");

        ButtonUpdateConsultation.setText("Update");


        MainPanel.add(PatientsPanel, "card2");

        LabelRegisterPatient.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        LabelRegisterPatient.setText("Register Patient");

        LabelRegisterPatientInfo.setText("Add a new patient to the system.");

        LabelRegisterCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterCPR.setText("CPR");

        TextFielRegisterCPR.setBackground(new java.awt.Color(240, 240, 240));
        TextFielRegisterCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFielRegisterCPR.setText("(Enter CPR)");
        TextFielRegisterCPR.setBorder(null);
        TextFielRegisterCPR.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFielRegisterCPR.getText().equals("(Enter CPR)")) {
                	TextFielRegisterCPR.setText("");
                	TextFielRegisterCPR.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFielRegisterCPR.getText().isEmpty()) {
                	TextFielRegisterCPR.setForeground(new java.awt.Color(0, 0, 0));
                	TextFielRegisterCPR.setText("(Enter CPR)");
                }
            }
         });

        LabelRegisterName.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterName.setText("Name");

        TextFieldRegisterName.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterName.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterName.setText("(Enter Name)");
        TextFieldRegisterName.setBorder(null);
        TextFieldRegisterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRegisterNameActionPerformed(evt);
            }
        });
        TextFieldRegisterName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterName.getText().equals("(Enter Name)")) {
                	TextFieldRegisterName.setText("");
                	TextFieldRegisterName.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterName.getText().isEmpty()) {
                	TextFieldRegisterName.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterName.setText("(Enter Name)");
                }
            }
         });

        LabelRegisterAddress.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterAddress.setText("Address");

        TextFieldRegisterAddress.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterAddress.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterAddress.setText("(Enter Address)");
        TextFieldRegisterAddress.setBorder(null);
        TextFieldRegisterAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRegisterAddressActionPerformed(evt);
            }
        });
        TextFieldRegisterAddress.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterAddress.getText().equals("(Enter Address)")) {
                	TextFieldRegisterAddress.setText("");
                	TextFieldRegisterAddress.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterAddress.getText().isEmpty()) {
                	TextFieldRegisterAddress.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterAddress.setText("(Enter Address)");
                }
            }
         });

        LabelRegisterEmail.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterEmail.setText("Email");

        TextFieldRegisterEmail.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterEmail.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterEmail.setText("(Enter Email)");
        TextFieldRegisterEmail.setBorder(null);
        TextFieldRegisterEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterEmail.getText().equals("(Enter Email)")) {
                	TextFieldRegisterEmail.setText("");
                	TextFieldRegisterEmail.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterEmail.getText().isEmpty()) {
                	TextFieldRegisterEmail.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterEmail.setText("(Enter Email)");
                }
            }
         });

        LabelRegisterPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterPhone.setText("Phone Number");

        TextFieldRegisterPhone.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterPhone.setText("(Enter Phone Number)");
        TextFieldRegisterPhone.setBorder(null);
        TextFieldRegisterPhone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterPhone.getText().equals("(Enter Phone Number)")) {
                	TextFieldRegisterPhone.setText("");
                	TextFieldRegisterPhone.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterPhone.getText().isEmpty()) {
                	TextFieldRegisterPhone.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterPhone.setText("(Enter Phone Number)");
                }
            }
         });

        LabelRegisterBirthday.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterBirthday.setText("Birthday");

        TextFieldRegisterBirthday.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterBirthday.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterBirthday.setText("(dd/mm/yyyy)");
        TextFieldRegisterBirthday.setBorder(null);
        TextFieldRegisterBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRegisterBirthdayActionPerformed(evt);
            }
        });
        TextFieldRegisterBirthday.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterBirthday.getText().equals("(dd/mm/yyyy)")) {
                	TextFieldRegisterBirthday.setText("");
                	TextFieldRegisterBirthday.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterBirthday.getText().isEmpty()) {
                	TextFieldRegisterBirthday.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterBirthday.setText("(dd/mm/yyyy)");
                }
            }
         });

        LabelRegisterSex.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterSex.setText("Sex");

        TextFieldRegisterSex.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterSex.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterSex.setText("(Enter Sex)");
        TextFieldRegisterSex.setBorder(null);
        TextFieldRegisterSex.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterSex.getText().equals("(Enter Sex)")) {
                	TextFieldRegisterSex.setText("");
                	TextFieldRegisterSex.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterSex.getText().isEmpty()) {
                	TextFieldRegisterSex.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterSex.setText("(Enter Sex)");
                }
            }
         });

        LabelRegisterBlood.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterBlood.setText("Blood Type");

        TextFieldRegisterBlood.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRegisterBlood.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRegisterBlood.setText("(Enter Blood Type)");
        TextFieldRegisterBlood.setBorder(null);
        TextFieldRegisterBlood.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRegisterBlood.getText().equals("(Enter Blood Type)")) {
                	TextFieldRegisterBlood.setText("");
                	TextFieldRegisterBlood.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRegisterBlood.getText().isEmpty()) {
                	TextFieldRegisterBlood.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRegisterBlood.setText("(Enter Blood Type)");
                }
            }
         });

        ButtonRegisterPatient.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        ButtonRegisterPatient.setText("Register");

        LabelRegisterPassword.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRegisterPassword.setText("Password");

        PasswordFieldRegisterPassword.setBackground(new java.awt.Color(240, 240, 240));
        PasswordFieldRegisterPassword.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        PasswordFieldRegisterPassword.setText("(Enter Password)");
        PasswordFieldRegisterPassword.setBorder(null);
        PasswordFieldRegisterPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (PasswordFieldRegisterPassword.getText().equals("(Enter Password)")) {
                	PasswordFieldRegisterPassword.setText("");
                	PasswordFieldRegisterPassword.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (PasswordFieldRegisterPassword.getText().isEmpty()) {
                	PasswordFieldRegisterPassword.setForeground(new java.awt.Color(0, 0, 0));
                	PasswordFieldRegisterPassword.setText("(Enter Password)");
                }
            }
         });

        LabelAddPatient.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        LabelAddPatient.setText("Add An Existing Patient");

        LabelAddPatientInfo.setText("Add an existing patient and create a consultation");

        LabelAddNewCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelAddNewCPR.setText("CPR");

        TextFieldAddNewCPR.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldAddNewCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldAddNewCPR.setText("(Enter CPR)");
        TextFieldAddNewCPR.setBorder(null);
        TextFieldAddNewCPR.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldAddNewCPR.getText().equals("(Enter CPR)")) {
                	TextFieldAddNewCPR.setText("");
                	TextFieldAddNewCPR.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldAddNewCPR.getText().isEmpty()) {
                	TextFieldAddNewCPR.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldAddNewCPR.setText("(Enter CPR)");
                }
            }
         });

        ButtonAddPatient.setText("Add");
        ButtonAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddPatientActionPerformed(evt);
            }
        });

        LabelRemovePatient.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        LabelRemovePatient.setText("Remove A Registered Patient");

        LabelRemovePatientInfo.setText("Remove a patient from your registry.");

        LabelRemovePatientCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelRemovePatientCPR.setText("CPR");

        TextFieldRemovePatientCPR.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldRemovePatientCPR.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldRemovePatientCPR.setText("(Enter CPR)");
        TextFieldRemovePatientCPR.setBorder(null);
        TextFieldRemovePatientCPR.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldRemovePatientCPR.getText().equals("(Enter CPR)")) {
                	TextFieldRemovePatientCPR.setText("");
                	TextFieldRemovePatientCPR.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldRemovePatientCPR.getText().isEmpty()) {
                	TextFieldRemovePatientCPR.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldRemovePatientCPR.setText("(Enter CPR)");
                }
            }
         });

        ButtonRemovePatient.setText("Remove");
        ButtonRemovePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemovePatientActionPerformed(evt);
            }
        });


        MainPanel.add(RegisterPatientPanel, "card3");

        LabelMyPersonalInfo.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        LabelMyPersonalInfo.setText("My Personal Information");

        LabelMyPersonalInfoText.setText("Review your personal information below.");

        LabelPersonalName.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalName.setText("Name");

        TextFieldPersonalName.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalName.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalName.setBorder(null);
        TextFieldPersonalName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalNameActionPerformed(evt);
            }
        });

        LabelPersonalAddress.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalAddress.setText("Address");

        TextFieldPersonalAddress.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalAddress.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalAddress.setBorder(null);
        TextFieldPersonalAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalAddressActionPerformed(evt);
            }
        });

        LabelPersonalEmail.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalEmail.setText("Email");

        TextFieldPersonalEmail.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalEmail.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalEmail.setBorder(null);

        LabelPersonalPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalPhone.setText("Phone Number");

        TextFieldPersonalPhone.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalPhone.setBorder(null);

        LabelPersonalBirthday.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalBirthday.setText("Birthday");

        TextFieldPersonalBirthday.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalBirthday.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalBirthday.setBorder(null);
        TextFieldPersonalBirthday.setEditable(false);
        TextFieldPersonalBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalBirthdayActionPerformed(evt);
            }
        });

        LabelPersonalOffice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalOffice.setText("Office");

        TextFieldPersonalOffice.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalOffice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalOffice.setBorder(null);
        TextFieldPersonalOffice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalOfficeActionPerformed(evt);
            }
        });

        LabelPersonalOfficePhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalOfficePhone.setText("Office Phone No");

        TextFieldPersonalOfficePhone.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalOfficePhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalOfficePhone.setBorder(null);
        TextFieldPersonalOfficePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalOfficePhoneActionPerformed(evt);
            }
        });

        LabelPersonalSpeciality.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalSpeciality.setText("Speciality");

        TextFieldPersonalSpeciality.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalSpeciality.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalSpeciality.setBorder(null);
        TextFieldPersonalSpeciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalSpecialityActionPerformed(evt);
            }
        });

        ButtonUpdatePersonalInfo.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        ButtonUpdatePersonalInfo.setText("Update");

        //update personal info fields with the right info
        try
        {
        	setPersonalInfo();
        }
        catch(Exception e){}
    }
    
    
    private void LabelButtonPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonPatientsMouseClicked
        setLabelColor(LabelButtonPatients);
        resetLabelColor(LabelButtonRegisterPatient);
        resetLabelColor(LabelButtonPersonalInfo);
        PatientsPanel.setVisible(true);
        RegisterPatientPanel.setVisible(false);
        PersonalInformationPanel.setVisible(false);
    }//GEN-LAST:event_LabelButtonPatientsMouseClicked

    private void LabelButtonRegisterPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonRegisterPatientMouseClicked
        setLabelColor(LabelButtonRegisterPatient);
        resetLabelColor(LabelButtonPatients);
        resetLabelColor(LabelButtonPersonalInfo);
        PatientsPanel.setVisible(false);
        RegisterPatientPanel.setVisible(true);
        PersonalInformationPanel.setVisible(false);
    }//GEN-LAST:event_LabelButtonRegisterPatientMouseClicked

    private void LabelButtonPersonalInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonPersonalInfoMouseClicked
        setLabelColor(LabelButtonPersonalInfo);
        resetLabelColor(LabelButtonRegisterPatient);
        resetLabelColor(LabelButtonPatients);
        PatientsPanel.setVisible(false);
        RegisterPatientPanel.setVisible(false);
        PersonalInformationPanel.setVisible(true);
    }//GEN-LAST:event_LabelButtonPersonalInfoMouseClicked

    private void TextFieldRegisterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRegisterNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldRegisterNameActionPerformed

    private void TextFieldRegisterAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRegisterAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldRegisterAddressActionPerformed

    private void TextFieldRegisterBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRegisterBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldRegisterBirthdayActionPerformed

    private void TextFieldPersonalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalNameActionPerformed

    private void TextFieldPersonalAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalAddressActionPerformed

    private void TextFieldPersonalBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalBirthdayActionPerformed

    private void TextFieldPersonalOfficeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalOfficeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalOfficeActionPerformed

    private void TextFieldPersonalOfficePhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalOfficePhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalOfficePhoneActionPerformed

    private void TextFieldPersonalSpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalSpecialityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalSpecialityActionPerformed

    private void ButtonAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAddPatientActionPerformed

    private void ButtonRemovePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemovePatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonRemovePatientActionPerformed
    private void setLabelColor(JLabel label)
    {
        label.setBackground(new Color(66, 134, 244));
    }
    private void resetLabelColor(JLabel label)
    {
        label.setBackground(new Color(34,58,96));
    }
    private void registerEventHandlers()
    {
    	TablePatients.getSelectionModel().addListSelectionListener(this);
    	ListConsultations.addListSelectionListener(this);
    	ButtonUpdateConsultation.addActionListener(this);
    	ButtonSearch.addActionListener(this);
    	ButtonShowAll.addActionListener(this);
    	ButtonRemoveConsultation.addActionListener(this);
    	ButtonCreateConsultation.addActionListener(this);
    	ButtonAddPatient.addActionListener(this);
    	ButtonRegisterPatient.addActionListener(this);
    	ButtonRemovePatient.addActionListener(this);
    	ButtonUpdatePersonalInfo.addActionListener(this);
    	
    	TextFieldSearchPatient.addKeyListener(new KeyAdapter() {
    		public void keyPressed(KeyEvent e)
    		{
    			if(e.getKeyCode() == KeyEvent.VK_ENTER)
    			{
    				ButtonSearch.doClick();
    			}
    		}
		});
    }

    private javax.swing.JButton ButtonAddPatient;
    private javax.swing.JButton ButtonCreateConsultation;
    private javax.swing.JButton ButtonRegisterPatient;
    private javax.swing.JButton ButtonRemoveConsultation;
    private javax.swing.JButton ButtonRemovePatient;
    private javax.swing.JButton ButtonSearch;
    private javax.swing.JButton ButtonShowAll;
    private javax.swing.JButton ButtonUpdateConsultation;
    private javax.swing.JButton ButtonUpdatePersonalInfo;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel LabelAddNewCPR;
    private javax.swing.JLabel LabelAddPatient;
    private javax.swing.JLabel LabelAddPatientInfo;
    private javax.swing.JLabel LabelButtonPatients;
    private javax.swing.JLabel LabelButtonPersonalInfo;
    private javax.swing.JLabel LabelButtonRegisterPatient;
    private javax.swing.JLabel LabelConsultations;
    private javax.swing.JLabel LabelDoctorNameLogIn;
    private javax.swing.JLabel LabelLoggedInAs;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogoInfo;
    private javax.swing.JLabel LabelMyPersonalInfo;
    private javax.swing.JLabel LabelMyPersonalInfoText;
    private javax.swing.JLabel LabelNotes;
    private javax.swing.JLabel LabelPatientInfoAddress;
    private javax.swing.JLabel LabelPatientInfoBirthday;
    private javax.swing.JLabel LabelPatientInfoBlood;
    private javax.swing.JLabel LabelPatientInfoCPR;
    private javax.swing.JLabel LabelPatientInfoEmail;
    private javax.swing.JLabel LabelPatientInfoName;
    private javax.swing.JLabel LabelPatients;
    private javax.swing.JLabel LabelPatientsInformation;
    private javax.swing.JLabel LabelPersonalAddress;
    private javax.swing.JLabel LabelPersonalBirthday;
    private javax.swing.JLabel LabelPersonalEmail;
    private javax.swing.JLabel LabelPersonalName;
    private javax.swing.JLabel LabelPersonalOffice;
    private javax.swing.JLabel LabelPersonalOfficePhone;
    private javax.swing.JLabel LabelPersonalPhone;
    private javax.swing.JLabel LabelPersonalSpeciality;
    private javax.swing.JLabel LabelRegisterAddress;
    private javax.swing.JLabel LabelRegisterBirthday;
    private javax.swing.JLabel LabelRegisterBlood;
    private javax.swing.JLabel LabelRegisterCPR;
    private javax.swing.JLabel LabelRegisterEmail;
    private javax.swing.JLabel LabelRegisterName;
    private javax.swing.JLabel LabelRegisterPassword;
    private javax.swing.JLabel LabelRegisterPatient;
    private javax.swing.JLabel LabelRegisterPatientInfo;
    private javax.swing.JLabel LabelRegisterPhone;
    private javax.swing.JLabel LabelRegisterSex;
    private javax.swing.JLabel LabelRemovePatient;
    private javax.swing.JLabel LabelRemovePatientCPR;
    private javax.swing.JLabel LabelRemovePatientInfo;
    private javax.swing.JList ListConsultations;
    private ArrayList<Consultation> consultationList;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPasswordField PasswordFieldRegisterPassword;
    private javax.swing.JPanel PatientsPanel;
    private javax.swing.JPanel PersonalInformationPanel;
    private javax.swing.JPanel RegisterPatientPanel;
    private javax.swing.JScrollPane ScrollPanelListConsultations;
    private javax.swing.JScrollPane ScrollPanelTablePatients;
    private javax.swing.JScrollPane ScrollPanelTextAreaNotes;
    private javax.swing.JTable TablePatients;
    private javax.swing.JTextArea TextAreaNotes;
    private javax.swing.JTextField TextFielPatientInfoBirthday;
    private javax.swing.JTextField TextFielRegisterCPR;
    private javax.swing.JTextField TextFieldAddNewCPR;
    private javax.swing.JTextField TextFieldPatientInfoAddress;
    private javax.swing.JTextField TextFieldPatientInfoBlood;
    private javax.swing.JTextField TextFieldPatientInfoCPR;
    private javax.swing.JTextField TextFieldPatientInfoEmail;
    private javax.swing.JTextField TextFieldPatientInfoName;
    private javax.swing.JTextField TextFieldPersonalAddress;
    private javax.swing.JTextField TextFieldPersonalBirthday;
    private javax.swing.JTextField TextFieldPersonalEmail;
    private javax.swing.JTextField TextFieldPersonalName;
    private javax.swing.JTextField TextFieldPersonalOffice;
    private javax.swing.JTextField TextFieldPersonalOfficePhone;
    private javax.swing.JTextField TextFieldPersonalPhone;
    private javax.swing.JTextField TextFieldPersonalSpeciality;
    private javax.swing.JTextField TextFieldRegisterAddress;
    private javax.swing.JTextField TextFieldRegisterBirthday;
    private javax.swing.JTextField TextFieldRegisterBlood;
    private javax.swing.JTextField TextFieldRegisterEmail;
    private javax.swing.JTextField TextFieldRegisterName;
    private javax.swing.JTextField TextFieldRegisterPhone;
    private javax.swing.JTextField TextFieldRegisterSex;
    private javax.swing.JTextField TextFieldRemovePatientCPR;
    private javax.swing.JTextField TextFieldSearchPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private DefaultTableModel patientsModel;
    private Controller controller;
    private void addAllPatients()
    {
    	try
    	{
    		ArrayList<Patient> p = controller.getAllPatients();
        	for(int i = 0; i < p.size(); i++)
        	{
        		addRow(p.get(i));
        	}
    	}
    	catch(Exception e){}
    }
    private void addRow(Patient p)
    {
    	try
    	{
    		String sex = p.getSex()+"";
        	String[] array = {p.getName(), p.getCPR(), p.getPhoneNumber(), sex};
        	patientsModel.addRow(array);
    	}
    	catch(Exception e1){}
    }
    private void emptyTable()
    {
    	try
    	{
    		patientsModel.setRowCount(0);
    	}
    	catch(Exception e){}
    }
    private void removeRow(int index)
    {
    	patientsModel.removeRow(index);
    }
    private String getPatientCPR(int index)
    {
    	String n = (String) patientsModel.getValueAt(index, 1);
    	return n;
    }
    private void setPersonalInfo()
    {
    	TextFieldPersonalAddress.setText(controller.getDoctorByIndex(0).getAddress());
        TextFieldPersonalBirthday.setText(controller.getDoctorByIndex(0).getBirthday().toString());
        TextFieldPersonalEmail.setText(controller.getDoctorByIndex(0).getEmail());
        TextFieldPersonalName.setText(controller.getDoctorByIndex(0).getName());
        TextFieldPersonalOffice.setText(controller.getDoctorByIndex(0).getOffice());
        TextFieldPersonalOfficePhone.setText(controller.getDoctorByIndex(0).getOfficePhoneNumber());
        TextFieldPersonalPhone.setText(controller.getDoctorByIndex(0).getPhoneNumber());
        TextFieldPersonalSpeciality.setText(controller.getDoctorByIndex(0).getSpeciality());
    }
    private void clearRegFields()
    {
    	TextFielRegisterCPR.setText("");
		TextFieldRegisterName.setText("");
		TextFieldRegisterAddress.setText("");
		TextFieldRegisterEmail.setText("");
		TextFieldRegisterPhone.setText("");
		TextFieldRegisterSex.setText("");
		TextFieldRegisterBlood.setText("");
		TextFieldRegisterBirthday.setText("");
		PasswordFieldRegisterPassword.setText("");
    }
    private void clearInfoFields()
    {
    	TextFieldPatientInfoCPR.setText("");
    	TextFieldPatientInfoName.setText("");
    	TextFielPatientInfoBirthday.setText("");
    	TextFieldPatientInfoEmail.setText("");
    	TextFieldPatientInfoBlood.setText("");
    	TextFieldPatientInfoAddress.setText("");
    }
    private boolean canRegister()
    {
    	boolean can = true;
    	if(TextFielRegisterCPR.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterName.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterAddress.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterEmail.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterPhone.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterBirthday.getText().startsWith("(dd"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterSex.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(TextFieldRegisterBlood.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	if(PasswordFieldRegisterPassword.getText().startsWith("(Ent"))
    	{
    		can = false;
    	}
    	return can;
    }
    private void fillInfoFields(Patient p)
    {
    	try
		{
			TextFieldPatientInfoCPR.setText(p.getCPR());
		}catch(Exception e1){}
		try
		{
			TextFieldPatientInfoName.setText(p.getName());
		}catch(Exception e1){}
		try
		{
			TextFielPatientInfoBirthday.setText(p.getBirthday().toString());
		}catch(Exception e1){}
		try
		{
			TextFieldPatientInfoEmail.setText(p.getEmail());
		}catch(Exception e1){}
		try
		{
			TextFieldPatientInfoBlood.setText(p.getBloodType());
		}catch(Exception e1){}
		try
		{
			TextFieldPatientInfoAddress.setText(p.getAddress());
		}catch(Exception e1){}
    }
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == TablePatients.getSelectionModel())
		{
			consultationList = controller.getConsultations(getPatientCPR(TablePatients.getSelectedRow()));
			ListConsultations.setListData(consultationList.toArray());
			try
			{
				Patient p = controller.getPatientByIndex(TablePatients.getSelectedRow());
				fillInfoFields(p);
				TextAreaNotes.setText("");
			}catch(Exception e1){}
		}
		else if(e.getSource() == ListConsultations)
		{
			try
			{
				TextAreaNotes.setText(consultationList.get(ListConsultations.getSelectedIndex()).getNotes());
			}catch(Exception e1){}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == ButtonUpdateConsultation)
		{
			String notes = "";
			Consultation c = new Consultation();
			try
			{
				c = consultationList.get(ListConsultations.getSelectedIndex());
				notes = c.getNotes();
				c.setNotes(TextAreaNotes.getText());
				if(!controller.updateConsultation(c))
				{
					TextAreaNotes.setText(notes);
				}
			}
			catch(Exception e1){}
		}
		else if(e.getSource() == ButtonSearch)
		{
			clearInfoFields();
			try
			{
				TablePatients.getSelectionModel().clearSelection();
				patientsModel.fireTableDataChanged();
				
			}catch(Exception e1){}
			String cpr = TextFieldSearchPatient.getText();
			TextFieldSearchPatient.setText("");
			Patient p = controller.getPatientByCprFromModel(cpr);
			emptyTable();
			addRow(p);
			try
			{
				TextAreaNotes.setText("");
				consultationList.clear();
				ListConsultations.setListData(consultationList.toArray());
			}catch(Exception e1){}
		}
		else if(e.getSource() == ButtonShowAll)
		{
			clearInfoFields();
			try
			{
				TablePatients.getSelectionModel().clearSelection();
				patientsModel.fireTableDataChanged();
			}catch(Exception e1){}
			emptyTable();
			addAllPatients();
			try
			{
				TextAreaNotes.setText("");
				consultationList.clear();
				ListConsultations.setListData(consultationList.toArray());
			}catch(Exception e1){}
		}
		else if(e.getSource() == ButtonRemoveConsultation)
		{
			try
			{
				Consultation c = consultationList.get(ListConsultations.getSelectedIndex());
				if(controller.removeConsultation(c.getId()))
				{
					TextAreaNotes.setText("");
					try{
						consultationList.clear();
					}catch(Exception e1){}
					consultationList = controller.getConsultations(c.getPatientCPR());
					try
					{
						ListConsultations.setListData(consultationList.toArray());
					}catch(Exception e1){}
				}
				String CPR = controller.getPatientByIndex(TablePatients.getSelectedRow()).getCPR();
				if(controller.getConsultations(CPR).size() == 0)
				{
					controller.removePatientFromModel(CPR);
					try
					{
						TablePatients.getSelectionModel().clearSelection();
						patientsModel.fireTableDataChanged();
						
					}catch(Exception e1){}
					emptyTable();
					addAllPatients();
				}
			}catch(Exception e1){}
		}
		else if(e.getSource() == ButtonCreateConsultation)
		{
			try
			{
				Consultation c = new Consultation();
				c.setPatientCPR(controller.getPatientByIndex(TablePatients.getSelectedRow()).getCPR());
				c.setDoctorCPR(controller.getDoctorByIndex(0).getCPR());
				c.setDate(new MyDate());
				if(controller.addConsultation(c))
				{
					try{
						consultationList.clear();
					}catch(Exception e1){}
					consultationList = controller.getConsultations(c.getPatientCPR());
					try
					{
						ListConsultations.setListData(consultationList.toArray());
					}catch(Exception e1){}
				}
			}catch(Exception e1){}
		}
		else if(e.getSource() == ButtonAddPatient)
		{
			String n = TextFieldAddNewCPR.getText();
			if(!n.startsWith("(Ent"))
			{
				if(!controller.existPatient(n))
				{
					Consultation c = new Consultation().setDoctorCPR(controller.getDoctorByIndex(0).getCPR())
							.setPatientCPR(n)
							.setDate(new MyDate());
					
					if(controller.addConsultation(c))
					{
						if(controller.getPatientByCprFromDB(n))
						{
							try
							{
								if(TablePatients.getSelectedRow() != -1)
								{
									TablePatients.getSelectionModel().clearSelection();
									patientsModel.fireTableDataChanged();
								}
								
							}catch(Exception e1){}
							emptyTable();
							addAllPatients();
							TextFieldAddNewCPR.setText("");
						}
						
					}
				}
			}
		}
		else if(e.getSource() == ButtonRegisterPatient)
		{
			System.out.println(canRegister());
			if(canRegister())
			{
				try
				{
					Patient p = new Patient().setCPR(TextFielRegisterCPR.getText())
							.setName(TextFieldRegisterName.getText())
							.setAddress(TextFieldRegisterAddress.getText())
							.setEmail(TextFieldRegisterEmail.getText())
							.setPhoneNumber(TextFieldRegisterPhone.getText())
							.setSex(TextFieldRegisterSex.getText().toUpperCase().charAt(0))
							.setBloodType(TextFieldRegisterBlood.getText());
					String birthday = TextFieldRegisterBirthday.getText();
					MyDate date = new MyDate(Integer.parseInt(birthday.substring(0, 2)), Integer.parseInt(birthday.substring(3, 5)),Integer.parseInt(birthday.substring(6,10)));
					p.setBirthday(date);
					p.setRegistrationDate(new MyDate());
					String password = PasswordFieldRegisterPassword.getText();
					Consultation c = new Consultation().setDoctorCPR(controller.getDoctorByIndex(0).getCPR())
					.setDate(new MyDate())
					.setPatientCPR(p.getCPR());
					if(controller.addPatient(p, password))
					{
						if(controller.addConsultation(c))
						{
							clearRegFields();
							try
							{
								TablePatients.getSelectionModel().clearSelection();
								patientsModel.fireTableDataChanged();
								
							}catch(Exception e1){}
							emptyTable();
							addAllPatients();
						}
					}
							
				}catch(Exception e1){}
			}
		}
		else if(e.getSource() == ButtonRemovePatient)
		{
			try
			{
				String CPR = TextFieldRemovePatientCPR.getText();
				TextFieldRemovePatientCPR.setText("");
				if(controller.existPatient(CPR))
				{
					ArrayList<Consultation> cons = controller.getConsultations(CPR);
					boolean isDone = true;
					for(int i = 0; i < cons.size(); i++)
					{
						isDone = controller.removeConsultation(cons.get(i).getId());
					}
					if(isDone)
					{
						controller.removePatientFromModel(CPR);
						try
						{
							TablePatients.getSelectionModel().clearSelection();
							patientsModel.fireTableDataChanged();
							
						}catch(Exception e1){}
						emptyTable();
						addAllPatients();
						
						try
						{
							consultationList.clear();
							ListConsultations.setListData(consultationList.toArray());
						}catch(Exception e1){}
						
					}
				}
			}
			catch(Exception e1){}
		}
		else if(e.getSource() == ButtonUpdatePersonalInfo)
		{
			try
			{
				Doctor d = new Doctor().setAddress(TextFieldPersonalAddress.getText())
						.setBirthday(controller.getDoctorByIndex(0).getBirthday())
						.setEmail(TextFieldPersonalEmail.getText())
						.setName(TextFieldPersonalName.getText())
						.setOffice(TextFieldPersonalOffice.getText())
						.setOfficePhoneNumber(TextFieldPersonalOfficePhone.getText())
						.setPhoneNumber(TextFieldPersonalPhone.getText())
						.setSpeciality(TextFieldPersonalSpeciality.getText())
						.setCPR(controller.getDoctorByIndex(0).getCPR());
				if(controller.updateDoctor(d))
				{
					setPersonalInfo();
				}
			}catch(Exception e1){}
		}
	}
}
