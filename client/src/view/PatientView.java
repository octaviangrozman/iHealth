package view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Consultation;
import model.Doctor;
import model.MyDate;
import model.Patient;
import controller.Controller;
import controller.LogInInterface;

public class PatientView extends javax.swing.JFrame implements LogInInterface, ActionListener, ListSelectionListener {

    /**
     * Creates new form DoctorView
     */
//	public static void main(String[] args)
//	{
//		PatientView v = new PatientView();
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
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		displayInitialData();
	}
    public PatientView() {
    	controller = controller.getInstance();
    	createComponents();
        initComponents();
        addComponentsToFrame();
        registerEventHandlers();
    }
    public void createComponents()
    {
    	HeaderPanel = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        LabelLogoInfo = new javax.swing.JLabel();
        LabelButtonDoctors = new javax.swing.JLabel();
        LabelButtonPersonalInfo = new javax.swing.JLabel();
        LabelLoggedInAs = new javax.swing.JLabel();
        LabelPatientNameLogIn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        DoctorsConsultationPanel = new javax.swing.JPanel();
        ScrollPanelTableDoctors = new javax.swing.JScrollPane();
        TableDoctors = new javax.swing.JTable();
        modelDoctors = new javax.swing.table.DefaultTableModel();
        LabelDoctors = new javax.swing.JLabel();
        TextFieldSearchDoctor = new javax.swing.JTextField();
        ButtonSearchDoctor = new javax.swing.JButton();
        ButtonShowAllDoctors = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        LabelConsultations = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ScrollPanelListConsultations = new javax.swing.JScrollPane();
        ListConsultations = new javax.swing.JList<>();
        LabelNotes = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ScrollPanelTextAreaNotes = new javax.swing.JScrollPane();
        TextAreaNotes = new javax.swing.JTextArea();
        LabelDoctorInformation = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        LabelDoctorInfoName = new javax.swing.JLabel();
        TextFieldDoctorInfoName = new javax.swing.JTextField();
        jSeparator24 = new javax.swing.JSeparator();
        LabelDoctorInfoPhone = new javax.swing.JLabel();
        TextFieldDoctorInfoPhone = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        LabelDoctorInfoEmail = new javax.swing.JLabel();
        TextFielDoctorInfoEmail = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        LabelDoctorInfoOffice = new javax.swing.JLabel();
        TextFieldDoctorInfoOffice = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        LabelDoctorInfoOfficePhone = new javax.swing.JLabel();
        TextFieldDoctorInfoOfficePhone = new javax.swing.JTextField();
        jSeparator28 = new javax.swing.JSeparator();
        LabelDoctorInfoSpeciality = new javax.swing.JLabel();
        TextFieldDoctorInfoSpeciality = new javax.swing.JTextField();
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
        LabelPersonalSex = new javax.swing.JLabel();
        TextFieldPersonalSex = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        LabelPersonalBlood = new javax.swing.JLabel();
        TextFieldPersonalBlood = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        LabelPersonalRegistrationDate = new javax.swing.JLabel();
        TextFieldPersonalRegistrationDate = new javax.swing.JTextField();
        jSeparator22 = new javax.swing.JSeparator();
        ButtonUpdatePersonalInfo = new javax.swing.JButton();
    }
    public void addComponentsToFrame()
    {
    	javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(LabelButtonDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelButtonPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLogo)
                    .addComponent(LabelLogoInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 635, Short.MAX_VALUE)
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLoggedInAs, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LabelPatientNameLogIn, javax.swing.GroupLayout.Alignment.TRAILING))
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
                        .addComponent(LabelPatientNameLogIn)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout DoctorsConsultationPanelLayout = new javax.swing.GroupLayout(DoctorsConsultationPanel);
        DoctorsConsultationPanel.setLayout(DoctorsConsultationPanelLayout);
        DoctorsConsultationPanelLayout.setHorizontalGroup(
            DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(LabelDoctors)
                        .addGap(76, 76, 76))
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TextFieldSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSearchDoctor)
                        .addGap(18, 18, 18)))
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonShowAllDoctors)
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(LabelConsultations)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelNotes)
                        .addGap(217, 217, 217))))
            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DoctorsConsultationPanelLayout.createSequentialGroup()
                                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator28, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsConsultationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelDoctorInfoOffice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFieldDoctorInfoOffice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsConsultationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelDoctorInfoSpeciality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFieldDoctorInfoSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48))
                            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                                        .addComponent(LabelDoctorInfoOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFieldDoctorInfoOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsConsultationPanelLayout.createSequentialGroup()
                                            .addComponent(LabelDoctorInfoPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextFieldDoctorInfoPhone))
                                        .addComponent(jSeparator24, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsConsultationPanelLayout.createSequentialGroup()
                                            .addComponent(LabelDoctorInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextFieldDoctorInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                        .addComponent(jSeparator25, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DoctorsConsultationPanelLayout.createSequentialGroup()
                                            .addComponent(LabelDoctorInfoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TextFielDoctorInfoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(LabelDoctorInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ScrollPanelTableDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(ScrollPanelListConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(ScrollPanelTextAreaNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        DoctorsConsultationPanelLayout.setVerticalGroup(
            DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDoctors)
                    .addComponent(LabelConsultations)
                    .addComponent(LabelNotes))
                .addGap(4, 4, 4)
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPanelListConsultations, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrollPanelTextAreaNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DoctorsConsultationPanelLayout.createSequentialGroup()
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSearchDoctor)
                            .addComponent(ButtonShowAllDoctors))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ScrollPanelTableDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelDoctorInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorInfoName)
                            .addComponent(TextFieldDoctorInfoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorInfoPhone)
                            .addComponent(TextFieldDoctorInfoPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorInfoEmail)
                            .addComponent(TextFielDoctorInfoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorInfoOffice)
                            .addComponent(TextFieldDoctorInfoOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorInfoOfficePhone)
                            .addComponent(TextFieldDoctorInfoOfficePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(DoctorsConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDoctorInfoSpeciality)
                            .addComponent(TextFieldDoctorInfoSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
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
                                    .addComponent(LabelPersonalRegistrationDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldPersonalRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                    .addComponent(LabelPersonalBlood)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldPersonalBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PersonalInformationPanelLayout.createSequentialGroup()
                                    .addComponent(LabelPersonalSex)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldPersonalSex, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(LabelPersonalSex)
                    .addComponent(TextFieldPersonalSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalBlood)
                    .addComponent(TextFieldPersonalBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PersonalInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPersonalRegistrationDate)
                    .addComponent(TextFieldPersonalRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonUpdatePersonalInfo)
                .addContainerGap(120, Short.MAX_VALUE))
        );
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

        LabelButtonDoctors.setBackground(new java.awt.Color(34, 58, 96));
        LabelButtonDoctors.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        LabelButtonDoctors.setForeground(new java.awt.Color(240, 240, 240));
        LabelButtonDoctors.setText("    Doctors and Consultations");
        LabelButtonDoctors.setOpaque(true);
        setLabelColor(LabelButtonDoctors);
        LabelButtonDoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelButtonDoctorsMouseClicked(evt);
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

        LabelPatientNameLogIn.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        LabelPatientNameLogIn.setForeground(new java.awt.Color(240, 240, 240));
        LabelPatientNameLogIn.setText("PATIENT's NAME HERE");

        jLabel1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/medicallogo.png"))); // NOI18N
        jLabel1.setText("jLabel1");


        MainPanel.setLayout(new java.awt.CardLayout());

        String[] modelColumns = {"Name", "CPR", "Office", "Speciality"};
        
        modelDoctors.setColumnIdentifiers(modelColumns);

        TableDoctors.setModel(modelDoctors);
        TableDoctors.setDefaultEditor(Object.class, null);
        TableDoctors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableDoctors.getSelectionModel().addListSelectionListener(this);

        ScrollPanelTableDoctors.setViewportView(TableDoctors);

        LabelDoctors.setText("Doctors");

        TextFieldSearchDoctor.setText("Search...");
        TextFieldSearchDoctor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TextFieldSearchDoctor.getText().equals("Search...")) {
                	TextFieldSearchDoctor.setText("");
                	TextFieldSearchDoctor.setForeground(new java.awt.Color(0, 0, 0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldSearchDoctor.getText().isEmpty()) {
                	TextFieldSearchDoctor.setForeground(new java.awt.Color(0, 0, 0));
                	TextFieldSearchDoctor.setText("Search...");
                }
            }
         });

        ButtonSearchDoctor.setText("Search");
        ButtonSearchDoctor.addActionListener(this);

        ButtonShowAllDoctors.setText("Show All");
        ButtonShowAllDoctors.addActionListener(this);

        LabelConsultations.setText("Consultations");
        
        ScrollPanelListConsultations.setViewportView(ListConsultations);
        ListConsultations.addListSelectionListener(this);

        LabelNotes.setText("Notes");

        TextAreaNotes.setColumns(20);
        TextAreaNotes.setRows(5);
        TextAreaNotes.setLineWrap(true);
        TextAreaNotes.setWrapStyleWord(true);
        TextAreaNotes.setEditable(false);
        ScrollPanelTextAreaNotes.setViewportView(TextAreaNotes);

        LabelDoctorInformation.setText("Doctor's Information");

        LabelDoctorInfoName.setText("Name");

        TextFieldDoctorInfoName.setEditable(false);

        LabelDoctorInfoPhone.setText("Phone Number");

        TextFieldDoctorInfoPhone.setEditable(false);

        LabelDoctorInfoEmail.setText("Email");

        TextFielDoctorInfoEmail.setEditable(false);

        LabelDoctorInfoOffice.setText("Office");

        TextFieldDoctorInfoOffice.setEditable(false);

        LabelDoctorInfoOfficePhone.setText("Office Phone Number");

        TextFieldDoctorInfoOfficePhone.setEditable(false);

        LabelDoctorInfoSpeciality.setText("Speciality");

        TextFieldDoctorInfoSpeciality.setEditable(false);


        MainPanel.add(DoctorsConsultationPanel, "card2");

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

        LabelPersonalSex.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalSex.setText("Sex");

        TextFieldPersonalSex.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalSex.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalSex.setBorder(null);
        TextFieldPersonalSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalSexActionPerformed(evt);
            }
        });

        LabelPersonalBlood.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalBlood.setText("Blood Type");

        TextFieldPersonalBlood.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalBlood.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalBlood.setBorder(null);
        TextFieldPersonalBlood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalBloodActionPerformed(evt);
            }
        });

        LabelPersonalRegistrationDate.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        LabelPersonalRegistrationDate.setText("Registration Date");

        TextFieldPersonalRegistrationDate.setBackground(new java.awt.Color(240, 240, 240));
        TextFieldPersonalRegistrationDate.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        TextFieldPersonalRegistrationDate.setBorder(null);
        TextFieldPersonalRegistrationDate.setEditable(false);
        TextFieldPersonalRegistrationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPersonalRegistrationDateActionPerformed(evt);
            }
        });

        ButtonUpdatePersonalInfo.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        ButtonUpdatePersonalInfo.setText("Update");
        ButtonUpdatePersonalInfo.addActionListener(this);


        MainPanel.add(PersonalInformationPanel, "card4");

    }// </editor-fold>//GEN-END:initComponents
    
    private void LabelButtonDoctorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonDoctorsMouseClicked
        setLabelColor(LabelButtonDoctors);
        resetLabelColor(LabelButtonPersonalInfo);
        DoctorsConsultationPanel.setVisible(true);
        PersonalInformationPanel.setVisible(false);
    }//GEN-LAST:event_LabelButtonDoctorsMouseClicked

    private void LabelButtonPersonalInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelButtonPersonalInfoMouseClicked
        setLabelColor(LabelButtonPersonalInfo);
        resetLabelColor(LabelButtonDoctors);
        DoctorsConsultationPanel.setVisible(false);
        PersonalInformationPanel.setVisible(true);
    }//GEN-LAST:event_LabelButtonPersonalInfoMouseClicked

    private void TextFieldPersonalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalNameActionPerformed

    private void TextFieldPersonalAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalAddressActionPerformed

    private void TextFieldPersonalBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalBirthdayActionPerformed

    private void TextFieldPersonalSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalSexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalSexActionPerformed

    private void TextFieldPersonalBloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalBloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalBloodActionPerformed

    private void TextFieldPersonalRegistrationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPersonalRegistrationDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldPersonalRegistrationDateActionPerformed
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

    private Controller controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSearchDoctor;
    private javax.swing.JButton ButtonShowAllDoctors;
    private javax.swing.JButton ButtonUpdatePersonalInfo;
    private javax.swing.JPanel DoctorsConsultationPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel LabelButtonDoctors;
    private javax.swing.JLabel LabelButtonPersonalInfo;
    private javax.swing.JLabel LabelConsultations;
    private javax.swing.JLabel LabelDoctorInfoEmail;
    private javax.swing.JLabel LabelDoctorInfoName;
    private javax.swing.JLabel LabelDoctorInfoOffice;
    private javax.swing.JLabel LabelDoctorInfoOfficePhone;
    private javax.swing.JLabel LabelDoctorInfoPhone;
    private javax.swing.JLabel LabelDoctorInfoSpeciality;
    private javax.swing.JLabel LabelDoctorInformation;
    private javax.swing.JLabel LabelPatientNameLogIn;
    private javax.swing.JLabel LabelDoctors;
    private javax.swing.JLabel LabelLoggedInAs;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelLogoInfo;
    private javax.swing.JLabel LabelMyPersonalInfo;
    private javax.swing.JLabel LabelMyPersonalInfoText;
    private javax.swing.JLabel LabelNotes;
    private javax.swing.JLabel LabelPersonalAddress;
    private javax.swing.JLabel LabelPersonalBirthday;
    private javax.swing.JLabel LabelPersonalBlood;
    private javax.swing.JLabel LabelPersonalEmail;
    private javax.swing.JLabel LabelPersonalName;
    private javax.swing.JLabel LabelPersonalPhone;
    private javax.swing.JLabel LabelPersonalRegistrationDate;
    private javax.swing.JLabel LabelPersonalSex;
    private javax.swing.JList<String> ListConsultations;
    private javax.swing.AbstractListModel<String> modelConsultations;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PersonalInformationPanel;
    private javax.swing.JScrollPane ScrollPanelListConsultations;
    private javax.swing.JScrollPane ScrollPanelTableDoctors;
    private javax.swing.JScrollPane ScrollPanelTextAreaNotes;
    private javax.swing.JTable TableDoctors;
    private javax.swing.table.DefaultTableModel modelDoctors;
    private javax.swing.JTextArea TextAreaNotes;
    private javax.swing.JTextField TextFielDoctorInfoEmail;
    private javax.swing.JTextField TextFieldDoctorInfoName;
    private javax.swing.JTextField TextFieldDoctorInfoOffice;
    private javax.swing.JTextField TextFieldDoctorInfoOfficePhone;
    private javax.swing.JTextField TextFieldDoctorInfoPhone;
    private javax.swing.JTextField TextFieldDoctorInfoSpeciality;
    private javax.swing.JTextField TextFieldPersonalAddress;
    private javax.swing.JTextField TextFieldPersonalBirthday;
    private javax.swing.JTextField TextFieldPersonalBlood;
    private javax.swing.JTextField TextFieldPersonalEmail;
    private javax.swing.JTextField TextFieldPersonalName;
    private javax.swing.JTextField TextFieldPersonalPhone;
    private javax.swing.JTextField TextFieldPersonalRegistrationDate;
    private javax.swing.JTextField TextFieldPersonalSex;
    private javax.swing.JTextField TextFieldSearchDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables

    private void displayInitialData() {
    	setLoggedInData();
    	showAllDoctors();
    	setPersonalInfo();
    }
    
    private void showAllDoctors() {
    	ArrayList<Doctor> allDoctors = controller.getAllDoctors();
    	while(modelDoctors.getRowCount() != 0) {
    		modelDoctors.removeRow(modelDoctors.getRowCount() - 1);
    	}
		for (Doctor doctor : allDoctors) {
			modelDoctors.addRow(new Object[]{doctor.getName(), doctor.getCPR(), doctor.getOffice(), doctor.getSpeciality()});
		}
    }
    
    private void setLoggedInData() {
    	Patient patient = controller.getAllPatients().get(0);
    	LabelPatientNameLogIn.setText(patient.getName());
    }
    
    private void displayConsultationsByDoctorCPR(String doctorCPR) {
    	ArrayList<Consultation> consultations = controller.getConsultationsByDoctorCpr(doctorCPR);
    	String[] names = new String[consultations.size()];
    	for (int i=0; i < names.length; i++) {
    		names[i] = (consultations.get(i).getDate().toString());
		}
    	ListConsultations.setListData(names);
    }
    
    private void setPersonalInfo() {
    	Patient patient = controller.getAllPatients().get(0);
    	TextFieldPersonalAddress.setText(patient.getAddress());
    	TextFieldPersonalBirthday.setText(patient.getBirthday().toString());
    	TextFieldPersonalBlood.setText(patient.getBloodType());
    	TextFieldPersonalEmail.setText(patient.getEmail());
    	TextFieldPersonalName.setText(patient.getName());
    	TextFieldPersonalPhone.setText(patient.getPhoneNumber());
    	TextFieldPersonalRegistrationDate.setText(patient.getRegistrationDate().toString());
    	TextFieldPersonalSex.setText(String.valueOf(patient.getSex()));
    }
    
    public void emptyDoctorInfo() {
    	TextFieldDoctorInfoName.setText("");
		TextFielDoctorInfoEmail.setText("");
		TextFieldDoctorInfoPhone.setText("");
		TextFieldDoctorInfoOffice.setText("");
		TextFieldDoctorInfoOfficePhone.setText("");
		TextFieldDoctorInfoSpeciality.setText("");
    }
    
    public void emptyConsultationList() {
    	ListConsultations.setListData(new String[0]);
    	TextAreaNotes.setText("");
    }
    
    public MyDate castStringToDate(String date) {
    	MyDate newDate = new MyDate(
			Integer.parseInt(date.substring(0, 2)), 
			Integer.parseInt(date.substring(3, 5)),
			Integer.parseInt(date.substring(6,10))
    	);
    	return newDate;
    }
    
    public void actionPerformed(ActionEvent e) {
    	
		if (e.getSource() == ButtonSearchDoctor) {
			String searchValue = TextFieldSearchDoctor.getText();
			TextFieldSearchDoctor.setText("");
			emptyDoctorInfo();
			emptyConsultationList();
			if (!searchValue.equalsIgnoreCase("Search...")) {
				Doctor doctor = controller.getDoctorByName(searchValue);
				modelDoctors.setRowCount(0);
				if (doctor != null) {
					modelDoctors.addRow(new Object[]{doctor.getName(), doctor.getCPR(), doctor.getOffice(), doctor.getSpeciality()});
				}
			}
		}
		
		else if (e.getSource() == ButtonShowAllDoctors) {
			showAllDoctors();
			emptyDoctorInfo();
			emptyConsultationList();
		}
		
		else if (e.getSource() == ButtonUpdatePersonalInfo) {
			Patient patient = new Patient();
			patient.setAddress(TextFieldPersonalAddress.getText())
				.setCPR(controller.getAllPatients().get(0).getCPR())
	    		.setBirthday(castStringToDate(TextFieldPersonalBirthday.getText()))
	    		.setBloodType(TextFieldPersonalBlood.getText())
	    		.setEmail(TextFieldPersonalEmail.getText())
	    		.setName(TextFieldPersonalName.getText())
	    		.setPhoneNumber(TextFieldPersonalPhone.getText())
	    		.setRegistrationDate(castStringToDate(TextFieldPersonalRegistrationDate.getText()))
	    		.setSex(TextFieldPersonalSex.getText().charAt(0));
			controller.updatePatient(patient);
			setPersonalInfo();
			System.out.println("updated personal info");
		}
		
	}

    public void registerEventHandlers() {
    	TextFieldSearchDoctor.addKeyListener(new KeyAdapter() {
    		public void keyPressed(KeyEvent e)
    		{
    			if(e.getKeyCode() == KeyEvent.VK_ENTER)
    			{
    				ButtonSearchDoctor.doClick();
    			}
    		}
		});
    }
    
    public void valueChanged(ListSelectionEvent e) {

    	if (e.getSource() == TableDoctors.getSelectionModel()) {
    		if (TableDoctors.getSelectedRow() > -1) {
	    		String doctorCPR = (String)TableDoctors.getValueAt(TableDoctors.getSelectedRow(), 1);
	    		Doctor doctor = controller.getDoctorByCpr(doctorCPR);
	    		TextFieldDoctorInfoName.setText(doctor.getName());
	    		TextFielDoctorInfoEmail.setText(doctor.getEmail());
	    		TextFieldDoctorInfoPhone.setText(doctor.getPhoneNumber());
	    		TextFieldDoctorInfoOffice.setText(doctor.getOffice());
	    		TextFieldDoctorInfoOfficePhone.setText(doctor.getOfficePhoneNumber());
	    		TextFieldDoctorInfoSpeciality.setText(doctor.getSpeciality());
	    		emptyConsultationList();
	    		displayConsultationsByDoctorCPR(doctorCPR);
    		}
    	}
    	
    	else if (e.getSource() == ListConsultations) {
    		if (ListConsultations.getSelectedIndex() != -1) {
    			int index = ListConsultations.getSelectedIndex();
    			ArrayList<Consultation> consultations = controller.getConsultationsByDoctorCpr((String)TableDoctors.getValueAt(TableDoctors.getSelectedRow(), 1));
    			TextAreaNotes.setText(consultations.get(index).getNotes());
    		}
    	}
    	
	}
}

