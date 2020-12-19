/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.admin.staff;

import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbhgg.dao.UsersDao;
import qlbhgg.dao.WorkDayDao;
import qlbhgg.models.Users;
import qlbhgg.models.WorkDay;
import qlbhgg.views.common.ConfirmDeleteStaff;
import qlbhgg.views.common.ConfirmOperations;
import qlbhgg.views.common.DisplayImage;

/**
 *
 * @author acer
 */
public class PanelStaff extends javax.swing.JPanel {

    /**
     * Creates new form PanelStaff
     */
    public ArrayList<Users> ListUsers = UsersDao.findStaff();
    public int countStaff = UsersDao.countStaff();
    public int setPageStaff;
    public Users u;
    
    public ArrayList<WorkDay> ListWorkday = new ArrayList<>();
    private final ArrayList<JLabel> ListLabelDaysCalendar = new ArrayList<JLabel>();
    
    Calendar cal = new GregorianCalendar();
    public int selectedMonth = cal.get(Calendar.MONTH);
    public int selectedYear = cal.get(Calendar.YEAR);
    public int dayEarlier = 0;
    public int numberOfWorking;

    public PanelStaff() throws SQLException {
        initComponents();
        showStaffList(ListUsers, countStaff);
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelList);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
        addLabelDays();
    }
    
    

    public void startingStateQLNV() {
        jPanelStaff1.setVisible(false);
        jPanelStaff2.setVisible(false);
        jPanelStaff3.setVisible(false);
        jPanelStaff4.setVisible(false);
        jPanelStaff5.setVisible(false);
        jPanelStaff6.setVisible(false);
    }

    public void showStaffList(ArrayList<Users> ListUsers, int countStaff) throws SQLException {
        startingStateQLNV();
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditBlue.png"));
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditLight.png"));
        if (pageStaff < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff), jPanelStaff1, jLabelNameStaff1, jLabelGenderStaff1, jLabelAvatar1, jLabelFrameStaff1, jLabelAddressStaff1, jLabelEmailStaff1, jLabelStatusStaff1);
        } else {
            jPanelStaff1.setVisible(false);
        }
        if (pageStaff + 1 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 1), jPanelStaff2, jLabelNameStaff2, jLabelGenderStaff2, jLabelAvatar2, jLabelFrameStaff2, jLabelAddressStaff2, jLabelEmailStaff2, jLabelStatusStaff2);
        } else {
            jPanelStaff2.setVisible(false);
        }
        if (pageStaff + 2 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 2), jPanelStaff3, jLabelNameStaff3, jLabelGenderStaff3, jLabelAvatar3, jLabelFrameStaff3, jLabelAddressStaff3, jLabelEmailStaff3, jLabelStatusStaff3);
        } else {
            jPanelStaff3.setVisible(false);
        }
        if (pageStaff + 3 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 3), jPanelStaff4, jLabelNameStaff4, jLabelGenderStaff4, jLabelAvatar4, jLabelFrameStaff4, jLabelAddressStaff4, jLabelEmailStaff4, jLabelStatusStaff4);
        } else {
            jPanelStaff4.setVisible(false);
        }
        if (pageStaff + 4 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 4), jPanelStaff5, jLabelNameStaff5, jLabelGenderStaff5, jLabelAvatar5, jLabelFrameStaff5, jLabelAddressStaff5, jLabelEmailStaff5, jLabelStatusStaff5);
        } else {
            jPanelStaff5.setVisible(false);
        }
        if (pageStaff + 5 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 5), jPanelStaff6, jLabelNameStaff6, jLabelGenderStaff6, jLabelAvatar6, jLabelFrameStaff6, jLabelAddressStaff6, jLabelEmailStaff6, jLabelStatusStaff6);
        } else {
            jPanelStaff6.setVisible(false);
        }
        if (pageStaff + 6 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 6), jPanelStaff7, jLabelNameStaff7, jLabelGenderStaff7, jLabelAvatar7, jLabelFrameStaff7, jLabelAddressStaff7, jLabelEmailStaff7, jLabelStatusStaff7);
        } else {
            jPanelStaff7.setVisible(false);
        }
        if (pageStaff + 7 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 7), jPanelStaff8, jLabelNameStaff8, jLabelGenderStaff8, jLabelAvatar8, jLabelFrameStaff8, jLabelAddressStaff8, jLabelEmailStaff8, jLabelStatusStaff8);
        } else {
            jPanelStaff8.setVisible(false);
        }
        if (pageStaff + 8 < countStaff) {
            renderJPanelStaff(ListUsers.get(pageStaff + 8), jPanelStaff9, jLabelNameStaff9, jLabelGenderStaff9, jLabelAvatar9, jLabelFrameStaff9, jLabelAddressStaff9, jLabelEmailStaff9, jLabelStatusStaff9);
        } else {
            jPanelStaff9.setVisible(false);
        }
        jLabelFrameSearchStaff.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
    }

    private void renderJPanelStaff(Users u, JPanel jpanel, JLabel jlabelNameStaff, JLabel jlabelGender, JLabel jlabelAvatar, JLabel jlabelFrameStaff, JLabel jlabelAddressStaff, JLabel jlabelEmailStaff, JLabel jLabelStatusStaff) {
        jpanel.setVisible(true);
        jpanel.setEnabled(true);
        jlabelNameStaff.setText(u.getFullname());
        jlabelGender.setText(u.getGender());
        if (u.getGender().equals("Nam")) {
            jlabelGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png")));
        } else {
            jlabelGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_20px.png")));
        }
        if (u.getStatus().equals("Hoạt động")) {
            jLabelStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png")));
        } else {
            jLabelStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px_1.png")));
        }
        jlabelAddressStaff.setText("<html>" + u.getAddress() + "</html>");
        jlabelFrameStaff.setIcon(scaleImageFrameStaff("/Image/Imformation.png"));
        jlabelAvatar.setIcon(scaleImageAvatar(u.getImage_user()));
        jlabelEmailStaff.setText(u.getEmail());
    }
    
    public void showCalendar() throws SQLException {
        numberOfWorking = WorkDayDao.countWorkDay(u.getId(), selectedMonth + 1, selectedYear);
        String titleCalendar = "Tháng " + String.valueOf(selectedMonth + 1) + " - " + String.valueOf(selectedYear);
        jLabelNumberOfWorking.setText("- Số buổi: " + String.valueOf(numberOfWorking) + "/28");
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, titleCalendar, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(153, 153, 255))); // NOI18N
        for (int i = 41; i > 34; i--) {
            ListLabelDaysCalendar.get(i).setText("");
        }
        ListLabelDaysCalendar.get(dayEarlier).setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleStatistical.setText("Bảng công và doanh số: " + titleCalendar);

        int cDay = cal.get(Calendar.DATE);
        int cMonth = cal.get(Calendar.MONTH);
        int cYear = cal.get(Calendar.YEAR);
        GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth, 1);
        int days = gCal.getActualMaximum(Calendar.DATE);
        int startInWeek = gCal.get(Calendar.DAY_OF_WEEK);

        gCal = new GregorianCalendar(selectedYear, selectedMonth, days);
        int totalweeks = gCal.getActualMaximum(Calendar.WEEK_OF_MONTH);

        int count = 1;

        for (int i = 1; i <= totalweeks; i++) {
            for (int j = 1; j <= 7; j++) {
                ListLabelDaysCalendar.get(count - 1).setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                if (selectedMonth <= cMonth && selectedYear <= cYear) {
                    if ((selectedYear <= cYear && selectedMonth < cMonth) || selectedYear < cYear) {
                        ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(207, 40, 40));
                    } else if ((count - startInWeek + 1) < cDay) {
                        ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(207, 40, 40));
                    } else {
                        ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(0, 0, 0));
                    }
                    for (WorkDay workDay : ListWorkday) {
                        if (workDay.getWorkday().getDate() == (count - startInWeek + 1) && workDay.getWorkday().getMonth() == selectedMonth && (workDay.getWorkday().getYear() + 1900) == selectedYear) {
                            ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(12, 194, 105));
                            ListLabelDaysCalendar.get(count - 1).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 194, 105)));
                        }
                    }
                } else {
                    ListLabelDaysCalendar.get(count - 1).setForeground(new java.awt.Color(0, 0, 0));
                }
                if (count < startInWeek || (count - startInWeek + 1) > 31) {
                    ListLabelDaysCalendar.get(count - 1).setText("");
                } else {
                    if (cDay == (count - startInWeek + 1) && cMonth == selectedMonth && cYear == selectedYear) {
                        ListLabelDaysCalendar.get(count - 1).setOpaque(true);
                        ListLabelDaysCalendar.get(count - 1).setText(String.valueOf(count - startInWeek + 1));
                        ListLabelDaysCalendar.get(count - 1).setBackground(new java.awt.Color(156, 176, 253));
                        dayEarlier = count - 1;
                    } else {
                        ListLabelDaysCalendar.get(count - 1).setText(String.valueOf(count - startInWeek + 1));
                    }
                }
                count++;
            }
        }
    }
    
    public void addLabelDays() {
        ListLabelDaysCalendar.add(jLabelDayCalendar1);
        ListLabelDaysCalendar.add(jLabelDayCalendar2);
        ListLabelDaysCalendar.add(jLabelDayCalendar3);
        ListLabelDaysCalendar.add(jLabelDayCalendar4);
        ListLabelDaysCalendar.add(jLabelDayCalendar5);
        ListLabelDaysCalendar.add(jLabelDayCalendar6);
        ListLabelDaysCalendar.add(jLabelDayCalendar7);
        ListLabelDaysCalendar.add(jLabelDayCalendar8);
        ListLabelDaysCalendar.add(jLabelDayCalendar9);
        ListLabelDaysCalendar.add(jLabelDayCalendar10);
        ListLabelDaysCalendar.add(jLabelDayCalendar11);
        ListLabelDaysCalendar.add(jLabelDayCalendar12);
        ListLabelDaysCalendar.add(jLabelDayCalendar13);
        ListLabelDaysCalendar.add(jLabelDayCalendar14);
        ListLabelDaysCalendar.add(jLabelDayCalendar15);
        ListLabelDaysCalendar.add(jLabelDayCalendar16);
        ListLabelDaysCalendar.add(jLabelDayCalendar17);
        ListLabelDaysCalendar.add(jLabelDayCalendar18);
        ListLabelDaysCalendar.add(jLabelDayCalendar19);
        ListLabelDaysCalendar.add(jLabelDayCalendar20);
        ListLabelDaysCalendar.add(jLabelDayCalendar21);
        ListLabelDaysCalendar.add(jLabelDayCalendar22);
        ListLabelDaysCalendar.add(jLabelDayCalendar23);
        ListLabelDaysCalendar.add(jLabelDayCalendar24);
        ListLabelDaysCalendar.add(jLabelDayCalendar25);
        ListLabelDaysCalendar.add(jLabelDayCalendar26);
        ListLabelDaysCalendar.add(jLabelDayCalendar27);
        ListLabelDaysCalendar.add(jLabelDayCalendar28);
        ListLabelDaysCalendar.add(jLabelDayCalendar29);
        ListLabelDaysCalendar.add(jLabelDayCalendar30);
        ListLabelDaysCalendar.add(jLabelDayCalendar31);
        ListLabelDaysCalendar.add(jLabelDayCalendar32);
        ListLabelDaysCalendar.add(jLabelDayCalendar33);
        ListLabelDaysCalendar.add(jLabelDayCalendar34);
        ListLabelDaysCalendar.add(jLabelDayCalendar35);
        ListLabelDaysCalendar.add(jLabelDayCalendar36);
        ListLabelDaysCalendar.add(jLabelDayCalendar37);
        ListLabelDaysCalendar.add(jLabelDayCalendar38);
        ListLabelDaysCalendar.add(jLabelDayCalendar39);
        ListLabelDaysCalendar.add(jLabelDayCalendar40);
        ListLabelDaysCalendar.add(jLabelDayCalendar41);
        ListLabelDaysCalendar.add(jLabelDayCalendar42);
    }
    
    private void renderJDashboardImformationStaff() throws SQLException {
        ListWorkday = WorkDayDao.findByUsername(u);
        selectedMonth = cal.get(Calendar.MONTH);
        selectedYear = cal.get(Calendar.YEAR);
        showCalendar();
        jLabelInformationNameStaff.setText(u.getFullname());
        jLabelAvatarStaff.setIcon(scaleImformationAvatar(u.getImage_user()));
        jLabelInformationId.setText(u.getId());
        jLabelInformationUsername.setText(u.getUsername());
        jLabelInformationGender.setText(u.getGender());
        if (u.getGender().equals("Nam")) {
            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png")));
        } else {
            jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_female_25px.png")));
        }
        jLabelInformationBirthday.setText(u.getBirthday().toString());
        jLabelInformationStartdate.setText(u.getStartdate().toString());
        jLabelInformationAddress.setText(u.getAddress());
        jLabelInformationEmail.setText(u.getEmail());
        jLabelInformationPhonenumber.setText(u.getPhonenumber());
        jLabelInformationBasicsalary.setText(String.format("%1$,.0f" + " VNĐ", u.getBasicsalary()));
        jLabelInformationAllowance.setText(String.format("%1$,.0f" + " VNĐ", u.getAllowance()));
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelButtonDeleteStaff.setVisible(true);
        jLabelBBButtonDeleteStaff.setVisible(true);
        jLabelButtonStatusStaff.setVisible(true);
        jLabelBBButtonStatusStaff.setVisible(true); 
        if (u.getStatus().equals("Hoạt động")) {
            jLabelButtonStatusStaff.setText("Hoạt động");
            jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png")));
            jLabelButtonStatusStaff.setForeground(Color.green);
        } else {
            jLabelButtonStatusStaff.setText("Khóa");
            jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px_1.png")));
            jLabelButtonStatusStaff.setForeground(Color.red);
        }
    }
    private ImageIcon scaleButtonEdit(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(270, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }
    private ImageIcon scaleImformationAvatar(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleImageAvatar(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(85, 85, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleImageFrameStaff(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(380, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleButtonAddStaff(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(190, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    private ImageIcon scaleButtonRefresh(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public void popUpImageStaff(int n) {
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        Users u = ListUsers.get(pageStaff + n);
        DisplayImage di = new DisplayImage(u.getFullname(), u.getImage_user());
        di.setVisible(true);
        di.pack();
        di.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDashboardQLNV = new javax.swing.JPanel();
        jPanelList = new javax.swing.JPanel();
        jPanelStaff1 = new javax.swing.JPanel();
        jLabelEditStaff1 = new javax.swing.JLabel();
        jLabelDeleteStaff1 = new javax.swing.JLabel();
        jLabelStatusStaff1 = new javax.swing.JLabel();
        jLabelGenderStaff1 = new javax.swing.JLabel();
        jLabelNameStaff1 = new javax.swing.JLabel();
        jLabelAddressStaff1 = new javax.swing.JLabel();
        jLabelEmailStaff1 = new javax.swing.JLabel();
        jLabelMessengerStaff1 = new javax.swing.JLabel();
        jLabelAvatarClick1 = new javax.swing.JLabel();
        jLabelFrameStaff1 = new javax.swing.JLabel();
        jLabelAvatar1 = new javax.swing.JLabel();
        jPanelStaff2 = new javax.swing.JPanel();
        jLabelDeleteStaff2 = new javax.swing.JLabel();
        jLabelEditStaff2 = new javax.swing.JLabel();
        jLabelStatusStaff2 = new javax.swing.JLabel();
        jLabelGenderStaff2 = new javax.swing.JLabel();
        jLabelNameStaff2 = new javax.swing.JLabel();
        jLabelAddressStaff2 = new javax.swing.JLabel();
        jLabelEmailStaff2 = new javax.swing.JLabel();
        jLabelMessengerStaff2 = new javax.swing.JLabel();
        jLabelAvatarClick2 = new javax.swing.JLabel();
        jLabelFrameStaff2 = new javax.swing.JLabel();
        jLabelAvatar2 = new javax.swing.JLabel();
        jPanelStaff3 = new javax.swing.JPanel();
        jLabelDeleteStaff3 = new javax.swing.JLabel();
        jLabelStatusStaff3 = new javax.swing.JLabel();
        jLabelGenderStaff3 = new javax.swing.JLabel();
        jLabelEditStaff3 = new javax.swing.JLabel();
        jLabelNameStaff3 = new javax.swing.JLabel();
        jLabelAddressStaff3 = new javax.swing.JLabel();
        jLabelEmailStaff3 = new javax.swing.JLabel();
        jLabelMessengerStaff3 = new javax.swing.JLabel();
        jLabelAvatarClick3 = new javax.swing.JLabel();
        jLabelFrameStaff3 = new javax.swing.JLabel();
        jLabelAvatar3 = new javax.swing.JLabel();
        jPanelStaff7 = new javax.swing.JPanel();
        jLabelDeleteStaff7 = new javax.swing.JLabel();
        jLabelStatusStaff7 = new javax.swing.JLabel();
        jLabelGenderStaff7 = new javax.swing.JLabel();
        jLabelNameStaff7 = new javax.swing.JLabel();
        jLabelEditStaff7 = new javax.swing.JLabel();
        jLabelAddressStaff7 = new javax.swing.JLabel();
        jLabelEmailStaff7 = new javax.swing.JLabel();
        jLabelMessengerStaff7 = new javax.swing.JLabel();
        jLabelAvatarClick7 = new javax.swing.JLabel();
        jLabelFrameStaff7 = new javax.swing.JLabel();
        jLabelAvatar7 = new javax.swing.JLabel();
        jPanelStaff8 = new javax.swing.JPanel();
        jLabelDeleteStaff8 = new javax.swing.JLabel();
        jLabelStatusStaff8 = new javax.swing.JLabel();
        jLabelGenderStaff8 = new javax.swing.JLabel();
        jLabelEditStaff8 = new javax.swing.JLabel();
        jLabelNameStaff8 = new javax.swing.JLabel();
        jLabelAddressStaff8 = new javax.swing.JLabel();
        jLabelEmailStaff8 = new javax.swing.JLabel();
        jLabelMessengerStaff8 = new javax.swing.JLabel();
        jLabelAvatarClick8 = new javax.swing.JLabel();
        jLabelFrameStaff8 = new javax.swing.JLabel();
        jLabelAvatar8 = new javax.swing.JLabel();
        jPanelStaff9 = new javax.swing.JPanel();
        jLabelDeleteStaff9 = new javax.swing.JLabel();
        jLabelStatusStaff9 = new javax.swing.JLabel();
        jLabelGenderStaff9 = new javax.swing.JLabel();
        jLabelNameStaff9 = new javax.swing.JLabel();
        jLabelEditStaff9 = new javax.swing.JLabel();
        jLabelAddressStaff9 = new javax.swing.JLabel();
        jLabelEmailStaff9 = new javax.swing.JLabel();
        jLabelMessengerStaff9 = new javax.swing.JLabel();
        jLabelAvatarClick9 = new javax.swing.JLabel();
        jLabelFrameStaff9 = new javax.swing.JLabel();
        jLabelAvatar9 = new javax.swing.JLabel();
        jPanelStaff4 = new javax.swing.JPanel();
        jLabelDeleteStaff4 = new javax.swing.JLabel();
        jLabelStatusStaff4 = new javax.swing.JLabel();
        jLabelGenderStaff4 = new javax.swing.JLabel();
        jLabelNameStaff4 = new javax.swing.JLabel();
        jLabelEditStaff4 = new javax.swing.JLabel();
        jLabelAddressStaff4 = new javax.swing.JLabel();
        jLabelEmailStaff4 = new javax.swing.JLabel();
        jLabelMessengerStaff4 = new javax.swing.JLabel();
        jLabelAvatarClick4 = new javax.swing.JLabel();
        jLabelFrameStaff4 = new javax.swing.JLabel();
        jLabelAvatar4 = new javax.swing.JLabel();
        jPanelStaff5 = new javax.swing.JPanel();
        jLabelDeleteStaff5 = new javax.swing.JLabel();
        jLabelStatusStaff5 = new javax.swing.JLabel();
        jLabelGenderStaff5 = new javax.swing.JLabel();
        jLabelEditStaff5 = new javax.swing.JLabel();
        jLabelNameStaff5 = new javax.swing.JLabel();
        jLabelAddressStaff5 = new javax.swing.JLabel();
        jLabelEmailStaff5 = new javax.swing.JLabel();
        jLabelMessengerStaff5 = new javax.swing.JLabel();
        jLabelAvatarClick5 = new javax.swing.JLabel();
        jLabelFrameStaff5 = new javax.swing.JLabel();
        jLabelAvatar5 = new javax.swing.JLabel();
        jPanelStaff6 = new javax.swing.JPanel();
        jLabelDeleteStaff6 = new javax.swing.JLabel();
        jLabelStatusStaff6 = new javax.swing.JLabel();
        jLabelGenderStaff6 = new javax.swing.JLabel();
        jLabelNameStaff6 = new javax.swing.JLabel();
        jLabelEditStaff6 = new javax.swing.JLabel();
        jLabelAddressStaff6 = new javax.swing.JLabel();
        jLabelEmailStaff6 = new javax.swing.JLabel();
        jLabelMessengerStaff6 = new javax.swing.JLabel();
        jLabelAvatarClick6 = new javax.swing.JLabel();
        jLabelFrameStaff6 = new javax.swing.JLabel();
        jLabelAvatar6 = new javax.swing.JLabel();
        jPanelControlPageStaff = new javax.swing.JPanel();
        jTextFieldPageStaff = new javax.swing.JTextField();
        jLabelPageStaff = new javax.swing.JLabel();
        jLabelRight2 = new javax.swing.JLabel();
        jLabelLeft2 = new javax.swing.JLabel();
        jLabelSkipToEnd2 = new javax.swing.JLabel();
        jLabelSkipToStart2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelTitleQLNV = new javax.swing.JLabel();
        jTextFieldSearchStaff = new javax.swing.JTextField();
        jLabelSearchStaff = new javax.swing.JLabel();
        jLabelButtonAddStaff = new javax.swing.JLabel();
        jLabelBBButtonAddStaff = new javax.swing.JLabel();
        jLabelButtonRefreshStaffList = new javax.swing.JLabel();
        jLabelBBButtonRefreshStaffList = new javax.swing.JLabel();
        jLabelFrameSearchStaff = new javax.swing.JLabel();
        jPanelInformationStaff = new javax.swing.JPanel();
        jLabelButtonDeleteStaff = new javax.swing.JLabel();
        jLabelBBButtonDeleteStaff = new javax.swing.JLabel();
        jLabelButtonStatusStaff = new javax.swing.JLabel();
        jLabelBBButtonStatusStaff = new javax.swing.JLabel();
        jLabelButtonEditStaff = new javax.swing.JLabel();
        jLabelBBButtonEditStaff = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelFrameAvatar = new javax.swing.JLabel();
        jLabelAvatarStaff = new javax.swing.JLabel();
        jLabelInformationNameStaff = new javax.swing.JLabel();
        jLabelTT = new javax.swing.JLabel();
        jLabelInformationUsername = new javax.swing.JLabel();
        jLabelInformationId = new javax.swing.JLabel();
        jLabelInformationGender = new javax.swing.JLabel();
        jLabelInformationBirthday = new javax.swing.JLabel();
        jLabelInformationStartdate = new javax.swing.JLabel();
        jLabelInformationAddress = new javax.swing.JLabel();
        jLabelInformationPhonenumber = new javax.swing.JLabel();
        jLabelInformationEmail = new javax.swing.JLabel();
        jLabelInformationBasicsalary = new javax.swing.JLabel();
        jLabelInformationAllowance = new javax.swing.JLabel();
        jLabelInformationId1 = new javax.swing.JLabel();
        jLabelInformationUsername1 = new javax.swing.JLabel();
        jLabelInformationGender1 = new javax.swing.JLabel();
        jLabelInformationBirthday1 = new javax.swing.JLabel();
        jLabelInformationStartdate1 = new javax.swing.JLabel();
        jLabelInformationAddress1 = new javax.swing.JLabel();
        jLabelInformationEmail1 = new javax.swing.JLabel();
        jLabelInformationPhonenumber1 = new javax.swing.JLabel();
        jLabelInformationBasicsalary1 = new javax.swing.JLabel();
        jLabelInformationAllowance1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelPreviousYear = new javax.swing.JLabel();
        jPanelCalendar = new javax.swing.JPanel();
        jLabelDayCalendar43 = new javax.swing.JLabel();
        jLabelDayCalendar44 = new javax.swing.JLabel();
        jLabelDayCalendar45 = new javax.swing.JLabel();
        jLabelDayCalendar46 = new javax.swing.JLabel();
        jLabelDayCalendar47 = new javax.swing.JLabel();
        jLabelDayCalendar48 = new javax.swing.JLabel();
        jLabelDayCalendar49 = new javax.swing.JLabel();
        jLabelDayCalendar1 = new javax.swing.JLabel();
        jLabelDayCalendar2 = new javax.swing.JLabel();
        jLabelDayCalendar3 = new javax.swing.JLabel();
        jLabelDayCalendar4 = new javax.swing.JLabel();
        jLabelDayCalendar5 = new javax.swing.JLabel();
        jLabelDayCalendar6 = new javax.swing.JLabel();
        jLabelDayCalendar7 = new javax.swing.JLabel();
        jLabelDayCalendar8 = new javax.swing.JLabel();
        jLabelDayCalendar9 = new javax.swing.JLabel();
        jLabelDayCalendar10 = new javax.swing.JLabel();
        jLabelDayCalendar11 = new javax.swing.JLabel();
        jLabelDayCalendar12 = new javax.swing.JLabel();
        jLabelDayCalendar13 = new javax.swing.JLabel();
        jLabelDayCalendar14 = new javax.swing.JLabel();
        jLabelDayCalendar15 = new javax.swing.JLabel();
        jLabelDayCalendar16 = new javax.swing.JLabel();
        jLabelDayCalendar17 = new javax.swing.JLabel();
        jLabelDayCalendar18 = new javax.swing.JLabel();
        jLabelDayCalendar19 = new javax.swing.JLabel();
        jLabelDayCalendar20 = new javax.swing.JLabel();
        jLabelDayCalendar21 = new javax.swing.JLabel();
        jLabelDayCalendar22 = new javax.swing.JLabel();
        jLabelDayCalendar23 = new javax.swing.JLabel();
        jLabelDayCalendar24 = new javax.swing.JLabel();
        jLabelDayCalendar25 = new javax.swing.JLabel();
        jLabelDayCalendar26 = new javax.swing.JLabel();
        jLabelDayCalendar27 = new javax.swing.JLabel();
        jLabelDayCalendar28 = new javax.swing.JLabel();
        jLabelDayCalendar29 = new javax.swing.JLabel();
        jLabelDayCalendar30 = new javax.swing.JLabel();
        jLabelDayCalendar31 = new javax.swing.JLabel();
        jLabelDayCalendar32 = new javax.swing.JLabel();
        jLabelDayCalendar33 = new javax.swing.JLabel();
        jLabelDayCalendar34 = new javax.swing.JLabel();
        jLabelDayCalendar35 = new javax.swing.JLabel();
        jLabelDayCalendar36 = new javax.swing.JLabel();
        jLabelDayCalendar37 = new javax.swing.JLabel();
        jLabelDayCalendar38 = new javax.swing.JLabel();
        jLabelDayCalendar39 = new javax.swing.JLabel();
        jLabelDayCalendar40 = new javax.swing.JLabel();
        jLabelDayCalendar41 = new javax.swing.JLabel();
        jLabelDayCalendar42 = new javax.swing.JLabel();
        jLabelNextYear = new javax.swing.JLabel();
        jLabelTitleStatistical = new javax.swing.JLabel();
        jLabelNumberOfWorking = new javax.swing.JLabel();
        jLabelNumberOfStatistical = new javax.swing.JLabel();
        jLabelNumberOfSalary = new javax.swing.JLabel();
        jLabelPreviousMonth = new javax.swing.JLabel();
        jLabelNextMonth = new javax.swing.JLabel();
        jLabelNameCalendar = new javax.swing.JLabel();

        jDashboardQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jDashboardQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jDashboardQLNV.setPreferredSize(new java.awt.Dimension(1330, 790));
        jDashboardQLNV.setLayout(new java.awt.CardLayout());

        jPanelList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelList.setPreferredSize(new java.awt.Dimension(1330, 870));
        jPanelList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEditStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelEditStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelDeleteStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelDeleteStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff1MouseClicked(evt);
            }
        });
        jPanelStaff1.add(jLabelStatusStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff1.setText("Nam");
        jLabelGenderStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff1.add(jLabelGenderStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff1.setText("Phạm Duy Tài");
        jLabelNameStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelNameStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff1.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff1.add(jLabelAddressStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff1.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff1.add(jLabelEmailStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff1.setText("Nhắn tin");
        jLabelMessengerStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff1MouseExited(evt);
            }
        });
        jPanelStaff1.add(jLabelMessengerStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick1MouseEntered(evt);
            }
        });
        jPanelStaff1.add(jLabelAvatarClick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff1.add(jLabelFrameStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff1.add(jLabelAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 380, 200));

        jPanelStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelDeleteStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelEditStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelEditStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelStatusStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff2MouseClicked(evt);
            }
        });
        jPanelStaff2.add(jLabelStatusStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff2.setText("Nam");
        jLabelGenderStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff2.add(jLabelGenderStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff2.setText("Phạm Duy Tài");
        jLabelNameStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelNameStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff2.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff2.add(jLabelAddressStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff2.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff2.add(jLabelEmailStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff2.setText("Nhắn tin");
        jLabelMessengerStaff2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff2MouseExited(evt);
            }
        });
        jPanelStaff2.add(jLabelMessengerStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick2MouseClicked(evt);
            }
        });
        jPanelStaff2.add(jLabelAvatarClick2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff2.add(jLabelFrameStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff2.add(jLabelAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 380, 200));

        jPanelStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelDeleteStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff3MouseClicked(evt);
            }
        });
        jPanelStaff3.add(jLabelStatusStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff3.setText("Nam");
        jLabelGenderStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff3.add(jLabelGenderStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelEditStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelEditStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelNameStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff3.setText("Phạm Duy Tài");
        jLabelNameStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelNameStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff3.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff3.add(jLabelAddressStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff3.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff3.add(jLabelEmailStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff3.setText("Nhắn tin");
        jLabelMessengerStaff3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff3MouseExited(evt);
            }
        });
        jPanelStaff3.add(jLabelMessengerStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick3MouseClicked(evt);
            }
        });
        jPanelStaff3.add(jLabelAvatarClick3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff3.add(jLabelFrameStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff3.add(jLabelAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 380, 200));

        jPanelStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelDeleteStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff7MouseClicked(evt);
            }
        });
        jPanelStaff7.add(jLabelStatusStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff7.setText("Nam");
        jLabelGenderStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff7.add(jLabelGenderStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff7.setText("Phạm Duy Tài");
        jLabelNameStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelNameStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelEditStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff7.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff7.add(jLabelAddressStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff7.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff7.add(jLabelEmailStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff7.setText("Nhắn tin");
        jLabelMessengerStaff7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff7MouseExited(evt);
            }
        });
        jPanelStaff7.add(jLabelMessengerStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick7MouseClicked(evt);
            }
        });
        jPanelStaff7.add(jLabelAvatarClick7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff7.add(jLabelFrameStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff7.add(jLabelAvatar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 380, 200));

        jPanelStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelDeleteStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff8MouseClicked(evt);
            }
        });
        jPanelStaff8.add(jLabelStatusStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff8.setText("Nam");
        jLabelGenderStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff8.add(jLabelGenderStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelEditStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelEditStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelNameStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff8.setText("Phạm Duy Tài");
        jLabelNameStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelNameStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff8.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff8.add(jLabelAddressStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff8.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff8.add(jLabelEmailStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff8.setText("Nhắn tin");
        jLabelMessengerStaff8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff8MouseExited(evt);
            }
        });
        jPanelStaff8.add(jLabelMessengerStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick8MouseClicked(evt);
            }
        });
        jPanelStaff8.add(jLabelAvatarClick8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff8.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff8.add(jLabelFrameStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff8.add(jLabelAvatar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, 380, 200));

        jPanelStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff9.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelDeleteStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff9MouseClicked(evt);
            }
        });
        jPanelStaff9.add(jLabelStatusStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff9.setText("Nam");
        jLabelGenderStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff9.add(jLabelGenderStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff9.setText("Phạm Duy Tài");
        jLabelNameStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelNameStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelEditStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff9.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff9.add(jLabelAddressStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff9.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff9.add(jLabelEmailStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff9.setText("Nhắn tin");
        jLabelMessengerStaff9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff9MouseExited(evt);
            }
        });
        jPanelStaff9.add(jLabelMessengerStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick9MouseClicked(evt);
            }
        });
        jPanelStaff9.add(jLabelAvatarClick9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff9.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff9.add(jLabelFrameStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff9.add(jLabelAvatar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 380, 200));

        jPanelStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelDeleteStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff4MouseClicked(evt);
            }
        });
        jPanelStaff4.add(jLabelStatusStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff4.setText("Nam");
        jLabelGenderStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff4.add(jLabelGenderStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff4.setText("Phạm Duy Tài");
        jLabelNameStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelNameStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelEditStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff4.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff4.add(jLabelAddressStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff4.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff4.add(jLabelEmailStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff4.setText("Nhắn tin");
        jLabelMessengerStaff4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff4MouseExited(evt);
            }
        });
        jPanelStaff4.add(jLabelMessengerStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick4MouseClicked(evt);
            }
        });
        jPanelStaff4.add(jLabelAvatarClick4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff4.add(jLabelFrameStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff4.add(jLabelAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 380, 200));

        jPanelStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelDeleteStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff5MouseClicked(evt);
            }
        });
        jPanelStaff5.add(jLabelStatusStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff5.setText("Nam");
        jLabelGenderStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff5.add(jLabelGenderStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelEditStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelEditStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelNameStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff5.setText("Phạm Duy Tài");
        jLabelNameStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelNameStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelAddressStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff5.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff5.add(jLabelAddressStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff5.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff5.add(jLabelEmailStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff5.setText("Nhắn tin");
        jLabelMessengerStaff5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff5MouseExited(evt);
            }
        });
        jPanelStaff5.add(jLabelMessengerStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick5MouseClicked(evt);
            }
        });
        jPanelStaff5.add(jLabelAvatarClick5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff5.add(jLabelFrameStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff5.add(jLabelAvatar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 380, 200));

        jPanelStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStaff6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelStaff6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDeleteStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDeleteStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDeleteStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelDeleteStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 147, 45, 30));

        jLabelStatusStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelStatusStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStatusStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStatusStaff6MouseClicked(evt);
            }
        });
        jPanelStaff6.add(jLabelStatusStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 148, 45, 30));

        jLabelGenderStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGenderStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGenderStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenderStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_20px.png"))); // NOI18N
        jLabelGenderStaff6.setText("Nam");
        jLabelGenderStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff6.add(jLabelGenderStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 130, -1));

        jLabelNameStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameStaff6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameStaff6.setText("Phạm Duy Tài");
        jLabelNameStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameStaff6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelNameStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 210, -1));

        jLabelEditStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelEditStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEditStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStaff6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelEditStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelEditStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 147, 45, 30));

        jLabelAddressStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAddressStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAddressStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddressStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_marker_20px.png"))); // NOI18N
        jLabelAddressStaff6.setText("Đồng Mai, Hà Đông, Hà Nội");
        jLabelAddressStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff6.add(jLabelAddressStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jLabelEmailStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmailStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmailStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmailStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_20px_1.png"))); // NOI18N
        jLabelEmailStaff6.setText("anhtai3d2y@gmail.com");
        jLabelEmailStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelStaff6.add(jLabelEmailStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 240, 30));

        jLabelMessengerStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMessengerStaff6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMessengerStaff6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMessengerStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessengerStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png"))); // NOI18N
        jLabelMessengerStaff6.setText("Nhắn tin");
        jLabelMessengerStaff6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMessengerStaff6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMessengerStaff6MouseExited(evt);
            }
        });
        jPanelStaff6.add(jLabelMessengerStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 184, 30));

        jLabelAvatarClick6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarClick6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarClick6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvatarClick6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvatarClick6MouseClicked(evt);
            }
        });
        jPanelStaff6.add(jLabelAvatarClick6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jLabelFrameStaff6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFrameStaff6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Imformation.png"))); // NOI18N
        jPanelStaff6.add(jLabelFrameStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 200));

        jLabelAvatar6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatar6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelStaff6.add(jLabelAvatar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 90));

        jPanelList.add(jPanelStaff6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 380, 200));

        jPanelControlPageStaff.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldPageStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageStaff.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageStaff.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageStaff.setText("1");
        jTextFieldPageStaff.setBorder(null);
        jTextFieldPageStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageStaffKeyReleased(evt);
            }
        });

        jLabelPageStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageStaff.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageStaff.setText("/4");

        jLabelRight2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRight2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRight2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRight2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRight2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRight2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRight2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRight2MouseExited(evt);
            }
        });

        jLabelLeft2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeft2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeft2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeft2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeft2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeft2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeft2MouseExited(evt);
            }
        });

        jLabelSkipToEnd2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEnd2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEnd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEnd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEnd2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEnd2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEnd2MouseExited(evt);
            }
        });

        jLabelSkipToStart2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStart2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStart2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStart2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStart2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStart2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStart2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlPageStaffLayout = new javax.swing.GroupLayout(jPanelControlPageStaff);
        jPanelControlPageStaff.setLayout(jPanelControlPageStaffLayout);
        jPanelControlPageStaffLayout.setHorizontalGroup(
            jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlPageStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSkipToStart2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPageStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPageStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRight2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSkipToEnd2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelControlPageStaffLayout.setVerticalGroup(
            jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlPageStaffLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSkipToStart2)
                    .addComponent(jLabelSkipToEnd2)
                    .addComponent(jLabelLeft2)
                    .addComponent(jLabelRight2)
                    .addGroup(jPanelControlPageStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPageStaff)
                        .addComponent(jLabelPageStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelList.add(jPanelControlPageStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 820, 200, 30));
        jPanelList.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1330, 10));

        jLabelTitleQLNV.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleQLNV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitleQLNV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleQLNV.setText("Quản lý nhân viên");
        jPanelList.add(jLabelTitleQLNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 230, -1));

        jTextFieldSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchStaff.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchStaff.setText("Tìm kiếm");
        jTextFieldSearchStaff.setBorder(null);
        jTextFieldSearchStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchStaff.setOpaque(false);
        jTextFieldSearchStaff.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchStaffFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchStaffFocusLost(evt);
            }
        });
        jTextFieldSearchStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchStaffKeyReleased(evt);
            }
        });
        jPanelList.add(jTextFieldSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 240, 30));

        jLabelSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchStaff.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelList.add(jLabelSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 30, 30));

        jLabelButtonAddStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonAddStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonAddStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_20px.png"))); // NOI18N
        jLabelButtonAddStaff.setText("Thêm nhân viên");
        jLabelButtonAddStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonAddStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonAddStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonAddStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonAddStaffMouseExited(evt);
            }
        });
        jPanelList.add(jLabelButtonAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 190, 30));

        jLabelBBButtonAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonAddStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelList.add(jLabelBBButtonAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 190, 30));

        jLabelButtonRefreshStaffList.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonRefreshStaffList.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonRefreshStaffList.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonRefreshStaffList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonRefreshStaffList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_refresh_20px.png"))); // NOI18N
        jLabelButtonRefreshStaffList.setText("Làm mới");
        jLabelButtonRefreshStaffList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonRefreshStaffList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshStaffListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshStaffListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshStaffListMouseExited(evt);
            }
        });
        jPanelList.add(jLabelButtonRefreshStaffList, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 130, 30));

        jLabelBBButtonRefreshStaffList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonRefreshStaffList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelList.add(jLabelBBButtonRefreshStaffList, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 130, 30));

        jLabelFrameSearchStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelList.add(jLabelFrameSearchStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 280, 30));

        jDashboardQLNV.add(jPanelList, "card2");

        jPanelInformationStaff.setBackground(new java.awt.Color(255, 255, 255));
        jPanelInformationStaff.setForeground(new java.awt.Color(255, 255, 255));
        jPanelInformationStaff.setPreferredSize(new java.awt.Dimension(1330, 790));
        jPanelInformationStaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelButtonDeleteStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonDeleteStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonDeleteStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonDeleteStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelButtonDeleteStaff.setText("Xóa nhân viên");
        jLabelButtonDeleteStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonDeleteStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonDeleteStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonDeleteStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonDeleteStaffMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelButtonDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 270, 40));

        jLabelBBButtonDeleteStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonDeleteStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelInformationStaff.add(jLabelBBButtonDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 270, 40));

        jLabelButtonStatusStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonStatusStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonStatusStaff.setForeground(new java.awt.Color(51, 255, 51));
        jLabelButtonStatusStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonStatusStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_sphere_20px.png"))); // NOI18N
        jLabelButtonStatusStaff.setText("Hoạt động");
        jLabelButtonStatusStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonStatusStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonStatusStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonStatusStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonStatusStaffMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelButtonStatusStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 270, 40));

        jLabelBBButtonStatusStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonStatusStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelInformationStaff.add(jLabelBBButtonStatusStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 270, 40));

        jLabelButtonEditStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelButtonEditStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelButtonEditStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonEditStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png"))); // NOI18N
        jLabelButtonEditStaff.setText("Sửa thông tin nhân viên");
        jLabelButtonEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonEditStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonEditStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonEditStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonEditStaffMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 270, 40));

        jLabelBBButtonEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBBButtonEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelInformationStaff.add(jLabelBBButtonEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 270, 40));
        jPanelInformationStaff.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1230, 10));

        jLabelFrameAvatar.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameAvatar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFrameAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFrameAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FrameAvatar.png"))); // NOI18N
        jLabelFrameAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFrameAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFrameAvatarMouseClicked(evt);
            }
        });
        jPanelInformationStaff.add(jLabelFrameAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 200));

        jLabelAvatarStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAvatarStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAvatarStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelInformationStaff.add(jLabelAvatarStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 200));

        jLabelInformationNameStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationNameStaff.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabelInformationNameStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationNameStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInformationNameStaff.setText("Phạm Duy Tài");
        jPanelInformationStaff.add(jLabelInformationNameStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 240, -1));

        jLabelTT.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTT.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTT.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTT.setText("Thông tin nhân viên:");
        jLabelTT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelInformationStaff.add(jLabelTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 40));

        jLabelInformationUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername.setText("Tên đăng nhập:");
        jPanelInformationStaff.add(jLabelInformationUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 440, 30));

        jLabelInformationId.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId.setText("Mã nhân viên:");
        jPanelInformationStaff.add(jLabelInformationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 440, 30));

        jLabelInformationGender.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender.setText("Giới tính:");
        jPanelInformationStaff.add(jLabelInformationGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 440, 30));

        jLabelInformationBirthday.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday.setText("Ngày sinh:");
        jPanelInformationStaff.add(jLabelInformationBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 440, 30));

        jLabelInformationStartdate.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate.setText("Ngày bắt đầu:");
        jPanelInformationStaff.add(jLabelInformationStartdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 440, 30));

        jLabelInformationAddress.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress.setText("Địa chỉ:");
        jPanelInformationStaff.add(jLabelInformationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 440, 30));

        jLabelInformationPhonenumber.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber.setText("Số điện thoại:");
        jPanelInformationStaff.add(jLabelInformationPhonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 440, 30));

        jLabelInformationEmail.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail.setText("Email:");
        jPanelInformationStaff.add(jLabelInformationEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 440, 30));

        jLabelInformationBasicsalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary.setText("Lương cơ bản:");
        jPanelInformationStaff.add(jLabelInformationBasicsalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 440, 30));

        jLabelInformationAllowance.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance.setText("Trợ cấp:");
        jPanelInformationStaff.add(jLabelInformationAllowance, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 440, 30));

        jLabelInformationId1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationId1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationId1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationId1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_identification_documents_25px.png"))); // NOI18N
        jLabelInformationId1.setText("Mã nhân viên:");
        jPanelInformationStaff.add(jLabelInformationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 160, 30));

        jLabelInformationUsername1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationUsername1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationUsername1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_name_25px.png"))); // NOI18N
        jLabelInformationUsername1.setText("Tên đăng nhập:");
        jPanelInformationStaff.add(jLabelInformationUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 160, 30));

        jLabelInformationGender1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationGender1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationGender1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationGender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_male_25px.png"))); // NOI18N
        jLabelInformationGender1.setText("Giới tính:");
        jPanelInformationStaff.add(jLabelInformationGender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 120, 30));

        jLabelInformationBirthday1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBirthday1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBirthday1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBirthday1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_birthday_25px.png"))); // NOI18N
        jLabelInformationBirthday1.setText("Ngày sinh:");
        jPanelInformationStaff.add(jLabelInformationBirthday1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

        jLabelInformationStartdate1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationStartdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationStartdate1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationStartdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_maintenance_date_25px.png"))); // NOI18N
        jLabelInformationStartdate1.setText("Ngày bắt đầu:");
        jPanelInformationStaff.add(jLabelInformationStartdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 150, 30));

        jLabelInformationAddress1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAddress1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAddress1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAddress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_home_address_25px.png"))); // NOI18N
        jLabelInformationAddress1.setText("Địa chỉ:");
        jPanelInformationStaff.add(jLabelInformationAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 100, 30));

        jLabelInformationEmail1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationEmail1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationEmail1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_gmail_25px_1.png"))); // NOI18N
        jLabelInformationEmail1.setText("Email:");
        jPanelInformationStaff.add(jLabelInformationEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 90, 30));

        jLabelInformationPhonenumber1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationPhonenumber1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationPhonenumber1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationPhonenumber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_phone_25px.png"))); // NOI18N
        jLabelInformationPhonenumber1.setText("Số điện thoại:");
        jPanelInformationStaff.add(jLabelInformationPhonenumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 150, 30));

        jLabelInformationBasicsalary1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationBasicsalary1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationBasicsalary1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationBasicsalary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_paycheque_25px.png"))); // NOI18N
        jLabelInformationBasicsalary1.setText("Lương cơ bản:");
        jPanelInformationStaff.add(jLabelInformationBasicsalary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 150, 30));

        jLabelInformationAllowance1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformationAllowance1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelInformationAllowance1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInformationAllowance1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_loyalty_card_25px.png"))); // NOI18N
        jLabelInformationAllowance1.setText("Trợ cấp:");
        jPanelInformationStaff.add(jLabelInformationAllowance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 740, 100, 30));
        jPanelInformationStaff.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 445, 440, 10));
        jPanelInformationStaff.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 485, 440, 10));
        jPanelInformationStaff.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 405, 440, 10));
        jPanelInformationStaff.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 525, 440, 10));
        jPanelInformationStaff.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 565, 440, 10));
        jPanelInformationStaff.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 605, 440, 10));
        jPanelInformationStaff.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 765, 440, 10));
        jPanelInformationStaff.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 645, 440, 10));
        jPanelInformationStaff.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 685, 440, 10));
        jPanelInformationStaff.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 725, 440, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelInformationStaff.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 10, 700));

        jLabelPreviousYear.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPreviousYear.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPreviousYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px.png"))); // NOI18N
        jLabelPreviousYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPreviousYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPreviousYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPreviousYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPreviousYearMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelPreviousYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 300, 60, 20));

        jPanelCalendar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tháng 12 2020", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(153, 153, 255))); // NOI18N
        jPanelCalendar.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDayCalendar43.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar43.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar43.setText("CN");
        jLabelDayCalendar43.setOpaque(true);
        jLabelDayCalendar43.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar43);

        jLabelDayCalendar44.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar44.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar44.setText("T2");
        jLabelDayCalendar44.setOpaque(true);
        jLabelDayCalendar44.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar44);

        jLabelDayCalendar45.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar45.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar45.setText("T3");
        jLabelDayCalendar45.setOpaque(true);
        jLabelDayCalendar45.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar45);

        jLabelDayCalendar46.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar46.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar46.setText("T4");
        jLabelDayCalendar46.setOpaque(true);
        jLabelDayCalendar46.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar46);

        jLabelDayCalendar47.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar47.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar47.setText("T5");
        jLabelDayCalendar47.setOpaque(true);
        jLabelDayCalendar47.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar47);

        jLabelDayCalendar48.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar48.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar48.setText("T6");
        jLabelDayCalendar48.setOpaque(true);
        jLabelDayCalendar48.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar48);

        jLabelDayCalendar49.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar49.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar49.setText("T7");
        jLabelDayCalendar49.setOpaque(true);
        jLabelDayCalendar49.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar49);

        jLabelDayCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar1.setText("1");
        jLabelDayCalendar1.setOpaque(true);
        jLabelDayCalendar1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar1);

        jLabelDayCalendar2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar2.setText("1");
        jLabelDayCalendar2.setOpaque(true);
        jLabelDayCalendar2.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar2);

        jLabelDayCalendar3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar3.setText("1");
        jLabelDayCalendar3.setOpaque(true);
        jLabelDayCalendar3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar3);

        jLabelDayCalendar4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar4.setText("1");
        jLabelDayCalendar4.setOpaque(true);
        jLabelDayCalendar4.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar4);

        jLabelDayCalendar5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar5.setText("1");
        jLabelDayCalendar5.setOpaque(true);
        jLabelDayCalendar5.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar5);

        jLabelDayCalendar6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar6.setText("1");
        jLabelDayCalendar6.setOpaque(true);
        jLabelDayCalendar6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar6);

        jLabelDayCalendar7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar7.setText("1");
        jLabelDayCalendar7.setOpaque(true);
        jLabelDayCalendar7.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar7);

        jLabelDayCalendar8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar8.setText("1");
        jLabelDayCalendar8.setOpaque(true);
        jLabelDayCalendar8.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar8);

        jLabelDayCalendar9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar9.setText("1");
        jLabelDayCalendar9.setOpaque(true);
        jLabelDayCalendar9.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar9);

        jLabelDayCalendar10.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar10.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar10.setText("1");
        jLabelDayCalendar10.setOpaque(true);
        jLabelDayCalendar10.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar10);

        jLabelDayCalendar11.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar11.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar11.setText("1");
        jLabelDayCalendar11.setOpaque(true);
        jLabelDayCalendar11.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar11);

        jLabelDayCalendar12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar12.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar12.setText("1");
        jLabelDayCalendar12.setOpaque(true);
        jLabelDayCalendar12.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar12);

        jLabelDayCalendar13.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar13.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar13.setText("1");
        jLabelDayCalendar13.setOpaque(true);
        jLabelDayCalendar13.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar13);

        jLabelDayCalendar14.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar14.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar14.setText("1");
        jLabelDayCalendar14.setOpaque(true);
        jLabelDayCalendar14.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar14);

        jLabelDayCalendar15.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar15.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar15.setText("1");
        jLabelDayCalendar15.setOpaque(true);
        jLabelDayCalendar15.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar15);

        jLabelDayCalendar16.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar16.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar16.setText("1");
        jLabelDayCalendar16.setOpaque(true);
        jLabelDayCalendar16.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar16);

        jLabelDayCalendar17.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar17.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar17.setText("1");
        jLabelDayCalendar17.setOpaque(true);
        jLabelDayCalendar17.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar17);

        jLabelDayCalendar18.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar18.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar18.setText("1");
        jLabelDayCalendar18.setOpaque(true);
        jLabelDayCalendar18.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar18);

        jLabelDayCalendar19.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar19.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar19.setText("1");
        jLabelDayCalendar19.setOpaque(true);
        jLabelDayCalendar19.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar19);

        jLabelDayCalendar20.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar20.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar20.setText("1");
        jLabelDayCalendar20.setOpaque(true);
        jLabelDayCalendar20.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar20);

        jLabelDayCalendar21.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar21.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar21.setText("1");
        jLabelDayCalendar21.setOpaque(true);
        jLabelDayCalendar21.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar21);

        jLabelDayCalendar22.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar22.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar22.setText("1");
        jLabelDayCalendar22.setOpaque(true);
        jLabelDayCalendar22.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar22);

        jLabelDayCalendar23.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar23.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar23.setText("1");
        jLabelDayCalendar23.setOpaque(true);
        jLabelDayCalendar23.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar23);

        jLabelDayCalendar24.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar24.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar24.setText("1");
        jLabelDayCalendar24.setOpaque(true);
        jLabelDayCalendar24.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar24);

        jLabelDayCalendar25.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar25.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar25.setText("1");
        jLabelDayCalendar25.setOpaque(true);
        jLabelDayCalendar25.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar25);

        jLabelDayCalendar26.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar26.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar26.setText("1");
        jLabelDayCalendar26.setOpaque(true);
        jLabelDayCalendar26.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar26);

        jLabelDayCalendar27.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar27.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar27.setText("1");
        jLabelDayCalendar27.setOpaque(true);
        jLabelDayCalendar27.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar27);

        jLabelDayCalendar28.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar28.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar28.setText("1");
        jLabelDayCalendar28.setOpaque(true);
        jLabelDayCalendar28.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar28);

        jLabelDayCalendar29.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar29.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar29.setText("1");
        jLabelDayCalendar29.setOpaque(true);
        jLabelDayCalendar29.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar29);

        jLabelDayCalendar30.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar30.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar30.setText("1");
        jLabelDayCalendar30.setOpaque(true);
        jLabelDayCalendar30.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar30);

        jLabelDayCalendar31.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar31.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar31.setText("1");
        jLabelDayCalendar31.setOpaque(true);
        jLabelDayCalendar31.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar31);

        jLabelDayCalendar32.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar32.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar32.setText("1");
        jLabelDayCalendar32.setOpaque(true);
        jLabelDayCalendar32.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar32);

        jLabelDayCalendar33.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar33.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar33.setText("1");
        jLabelDayCalendar33.setOpaque(true);
        jLabelDayCalendar33.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar33);

        jLabelDayCalendar34.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar34.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar34.setText("1");
        jLabelDayCalendar34.setOpaque(true);
        jLabelDayCalendar34.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar34);

        jLabelDayCalendar35.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar35.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar35.setText("1");
        jLabelDayCalendar35.setOpaque(true);
        jLabelDayCalendar35.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar35);

        jLabelDayCalendar36.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar36.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar36.setText("15");
        jLabelDayCalendar36.setOpaque(true);
        jLabelDayCalendar36.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar36);

        jLabelDayCalendar37.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar37.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar37.setText("15");
        jLabelDayCalendar37.setOpaque(true);
        jLabelDayCalendar37.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar37);

        jLabelDayCalendar38.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar38.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar38.setText("15");
        jLabelDayCalendar38.setOpaque(true);
        jLabelDayCalendar38.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar38);

        jLabelDayCalendar39.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar39.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar39.setText("15");
        jLabelDayCalendar39.setOpaque(true);
        jLabelDayCalendar39.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar39);

        jLabelDayCalendar40.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar40.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar40.setText("15");
        jLabelDayCalendar40.setOpaque(true);
        jLabelDayCalendar40.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar40);

        jLabelDayCalendar41.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar41.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar41.setText("15");
        jLabelDayCalendar41.setOpaque(true);
        jLabelDayCalendar41.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar41);

        jLabelDayCalendar42.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDayCalendar42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDayCalendar42.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDayCalendar42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDayCalendar42.setText("15");
        jLabelDayCalendar42.setOpaque(true);
        jLabelDayCalendar42.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanelCalendar.add(jLabelDayCalendar42);

        jPanelInformationStaff.add(jPanelCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 420, 430));

        jLabelNextYear.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNextYear.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNextYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px.png"))); // NOI18N
        jLabelNextYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNextYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNextYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNextYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNextYearMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelNextYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 300, 60, 20));

        jLabelTitleStatistical.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleStatistical.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTitleStatistical.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleStatistical.setText("Bảng công và doanh số:");
        jLabelTitleStatistical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelInformationStaff.add(jLabelTitleStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 600, 40));

        jLabelNumberOfWorking.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfWorking.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfWorking.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfWorking.setText("- Số buổi:");
        jPanelInformationStaff.add(jLabelNumberOfWorking, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 560, 30));

        jLabelNumberOfStatistical.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfStatistical.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfStatistical.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfStatistical.setText("- Doanh số:");
        jPanelInformationStaff.add(jLabelNumberOfStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 560, 30));

        jLabelNumberOfSalary.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberOfSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNumberOfSalary.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumberOfSalary.setText("- Lương:");
        jPanelInformationStaff.add(jLabelNumberOfSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 560, 30));

        jLabelPreviousMonth.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPreviousMonth.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPreviousMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px.png"))); // NOI18N
        jLabelPreviousMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPreviousMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPreviousMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPreviousMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPreviousMonthMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelPreviousMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, 30, 60));

        jLabelNextMonth.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNextMonth.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNextMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px.png"))); // NOI18N
        jLabelNextMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNextMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNextMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNextMonthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNextMonthMouseExited(evt);
            }
        });
        jPanelInformationStaff.add(jLabelNextMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 500, 30, 60));

        jLabelNameCalendar.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNameCalendar.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabelNameCalendar.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNameCalendar.setText("Bảng chấm công");
        jPanelInformationStaff.add(jLabelNameCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 760, 100, -1));

        jDashboardQLNV.add(jPanelInformationStaff, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDashboardQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDashboardQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelEditStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff1MouseClicked

    private void jLabelEditStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseEntered
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff1MouseEntered

    private void jLabelEditStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff1MouseExited
        // TODO add your handling code here:
        jLabelEditStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff1MouseExited

    private void jLabelDeleteStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff1MouseClicked

    private void jLabelDeleteStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff1MouseEntered

    private void jLabelDeleteStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff1MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff1MouseExited

    private void jLabelStatusStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff1MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff1MouseClicked

    private void jLabelNameStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseClicked
        // TODO add your handling code here:
        jDashboardQLNV.removeAll();
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff1MouseClicked

    private void jLabelNameStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff1MouseEntered

    private void jLabelNameStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff1MouseExited
        // TODO add your handling code here:
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff1MouseExited

    private void jLabelMessengerStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff1MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff1.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff1MouseEntered

    private void jLabelMessengerStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff1MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff1MouseExited

    private void jLabelAvatarClick1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick1MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(0);
    }//GEN-LAST:event_jLabelAvatarClick1MouseClicked

    private void jLabelAvatarClick1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelAvatarClick1MouseEntered

    private void jLabelDeleteStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff2MouseClicked

    private void jLabelDeleteStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff2MouseEntered

    private void jLabelDeleteStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff2MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff2MouseExited

    private void jLabelEditStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff2MouseClicked

    private void jLabelEditStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff2MouseEntered

    private void jLabelEditStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff2MouseExited
        // TODO add your handling code here:
        jLabelEditStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff2MouseExited

    private void jLabelStatusStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff2MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff2MouseClicked

    private void jLabelNameStaff2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 1);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff2MouseClicked

    private void jLabelNameStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff2MouseEntered

    private void jLabelNameStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff2MouseExited
        // TODO add your handling code here:
        jLabelNameStaff2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff2MouseExited

    private void jLabelMessengerStaff2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff2MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff2.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff2MouseEntered

    private void jLabelMessengerStaff2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff2MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff2MouseExited

    private void jLabelAvatarClick2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick2MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(1);
    }//GEN-LAST:event_jLabelAvatarClick2MouseClicked

    private void jLabelDeleteStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff3MouseClicked

    private void jLabelDeleteStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff3MouseEntered

    private void jLabelDeleteStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff3MouseExited
        // TODO add your handling code here:
        jLabelDeleteStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff3MouseExited

    private void jLabelStatusStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff3MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff3MouseClicked

    private void jLabelEditStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff3MouseClicked

    private void jLabelEditStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff3MouseEntered

    private void jLabelEditStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff3MouseExited
        // TODO add your handling code here:
        jLabelEditStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff3MouseExited

    private void jLabelNameStaff3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 2);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff3MouseClicked

    private void jLabelNameStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff3MouseEntered

    private void jLabelNameStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff3MouseExited
        // TODO add your handling code here:
        jLabelNameStaff3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff3MouseExited

    private void jLabelMessengerStaff3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff3MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff3.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff3MouseEntered

    private void jLabelMessengerStaff3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff3MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff3MouseExited

    private void jLabelAvatarClick3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick3MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(2);
    }//GEN-LAST:event_jLabelAvatarClick3MouseClicked

    private void jLabelDeleteStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff7MouseClicked

    private void jLabelDeleteStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff7MouseEntered
        jLabelDeleteStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff7MouseEntered

    private void jLabelDeleteStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff7MouseExited
        jLabelDeleteStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff7MouseExited

    private void jLabelStatusStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff7MouseClicked

    private void jLabelNameStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff7MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff7MouseClicked

    private void jLabelNameStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff7MouseEntered
        jLabelNameStaff7.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff7MouseEntered

    private void jLabelNameStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff7MouseExited
        jLabelNameStaff7.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff7MouseExited

    private void jLabelEditStaff7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff7MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 6);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff7MouseClicked

    private void jLabelEditStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff7MouseEntered
        jLabelEditStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff7MouseEntered

    private void jLabelEditStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff7MouseExited
        jLabelEditStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff7MouseExited

    private void jLabelMessengerStaff7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff7MouseEntered
        jLabelMessengerStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff7.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff7MouseEntered

    private void jLabelMessengerStaff7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff7MouseExited
        jLabelMessengerStaff7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff7.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff7MouseExited

    private void jLabelAvatarClick7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick7MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(6);
    }//GEN-LAST:event_jLabelAvatarClick7MouseClicked

    private void jLabelDeleteStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff8MouseClicked

    private void jLabelDeleteStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff8MouseEntered
        jLabelDeleteStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff8MouseEntered

    private void jLabelDeleteStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff8MouseExited
        jLabelDeleteStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff8MouseExited

    private void jLabelStatusStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff8MouseClicked

    private void jLabelEditStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff8MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff8MouseClicked

    private void jLabelEditStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff8MouseEntered
        jLabelEditStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff8MouseEntered

    private void jLabelEditStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff8MouseExited
        jLabelEditStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff8MouseExited

    private void jLabelNameStaff8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff8MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 7);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff8MouseClicked

    private void jLabelNameStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff8MouseEntered
        jLabelNameStaff8.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff8MouseEntered

    private void jLabelNameStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff8MouseExited
        jLabelNameStaff8.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff8MouseExited

    private void jLabelMessengerStaff8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff8MouseEntered
        jLabelMessengerStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff8.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff8MouseEntered

    private void jLabelMessengerStaff8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff8MouseExited
        jLabelMessengerStaff8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff8.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff8MouseExited

    private void jLabelAvatarClick8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick8MouseClicked
        popUpImageStaff(7);
    }//GEN-LAST:event_jLabelAvatarClick8MouseClicked

    private void jLabelDeleteStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff9MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff9MouseClicked

    private void jLabelDeleteStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff9MouseEntered
        jLabelDeleteStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff9MouseEntered

    private void jLabelDeleteStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff9MouseExited
        jLabelDeleteStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff9MouseExited

    private void jLabelStatusStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff9MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff9MouseClicked

    private void jLabelNameStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff9MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff9MouseClicked

    private void jLabelNameStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff9MouseEntered
        jLabelNameStaff9.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff9MouseEntered

    private void jLabelNameStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff9MouseExited
        jLabelNameStaff9.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff9MouseExited

    private void jLabelEditStaff9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff9MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 8);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff9MouseClicked

    private void jLabelEditStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff9MouseEntered
        jLabelEditStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff9MouseEntered

    private void jLabelEditStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff9MouseExited
        jLabelEditStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff9MouseExited

    private void jLabelMessengerStaff9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff9MouseEntered
        jLabelMessengerStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff9.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff9MouseEntered

    private void jLabelMessengerStaff9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff9MouseExited
        jLabelMessengerStaff9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff9.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff9MouseExited

    private void jLabelAvatarClick9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick9MouseClicked
        popUpImageStaff(8);
    }//GEN-LAST:event_jLabelAvatarClick9MouseClicked

    private void jLabelDeleteStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff4MouseClicked

    private void jLabelDeleteStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseEntered
        // TODO add your handling code here:
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff4MouseEntered

    private void jLabelDeleteStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff4MouseExited
        jLabelDeleteStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff4MouseExited

    private void jLabelStatusStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff4MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff4MouseClicked

    private void jLabelNameStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff4MouseClicked

    private void jLabelNameStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff4MouseEntered

    private void jLabelNameStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff4MouseExited
        // TODO add your handling code here:
        jLabelNameStaff4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff4MouseExited

    private void jLabelEditStaff4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 3);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff4MouseClicked

    private void jLabelEditStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff4MouseEntered

    private void jLabelEditStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff4MouseExited
        // TODO add your handling code here:
        jLabelEditStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff4MouseExited

    private void jLabelMessengerStaff4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff4MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff4.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff4MouseEntered

    private void jLabelMessengerStaff4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff4MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff4MouseExited

    private void jLabelAvatarClick4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick4MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(3);
    }//GEN-LAST:event_jLabelAvatarClick4MouseClicked

    private void jLabelDeleteStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff5MouseClicked

    private void jLabelDeleteStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseEntered
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff5MouseEntered

    private void jLabelDeleteStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff5MouseExited
        jLabelDeleteStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff5MouseExited

    private void jLabelStatusStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff5MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff5MouseClicked

    private void jLabelEditStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff5MouseClicked

    private void jLabelEditStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff5MouseEntered

    private void jLabelEditStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff5MouseExited
        // TODO add your handling code here:
        jLabelEditStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff5MouseExited

    private void jLabelNameStaff5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 4);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff5MouseClicked

    private void jLabelNameStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff5MouseEntered

    private void jLabelNameStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff5MouseExited
        // TODO add your handling code here:
        jLabelNameStaff5.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff5MouseExited

    private void jLabelMessengerStaff5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff5MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff5.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff5MouseEntered

    private void jLabelMessengerStaff5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff5MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff5.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff5MouseExited

    private void jLabelAvatarClick5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick5MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(4);
    }//GEN-LAST:event_jLabelAvatarClick5MouseClicked

    private void jLabelDeleteStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelDeleteStaff6MouseClicked

    private void jLabelDeleteStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseEntered
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDeleteStaff6MouseEntered

    private void jLabelDeleteStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteStaff6MouseExited
        jLabelDeleteStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDeleteStaff6MouseExited

    private void jLabelStatusStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStatusStaff6MouseClicked
        // TODO add your handling code here:
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelStatusStaff6MouseClicked

    private void jLabelNameStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseClicked
        jLabelNameStaff1.setForeground(new java.awt.Color(0, 0, 0));
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        try {
            renderJDashboardImformationStaff();
            showCalendar();
        } catch (SQLException ex) {
            Logger.getLogger(PanelStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDashboardQLNV.removeAll();
        jDashboardQLNV.add(jPanelInformationStaff);
        jDashboardQLNV.validate();
        jDashboardQLNV.repaint();
    }//GEN-LAST:event_jLabelNameStaff6MouseClicked

    private void jLabelNameStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseEntered
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelNameStaff6MouseEntered

    private void jLabelNameStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameStaff6MouseExited
        // TODO add your handling code here:
        jLabelNameStaff6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameStaff6MouseExited

    private void jLabelEditStaff6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseClicked
        setPageStaff = (countStaff % 9 == 0) ? 0 : 1;
        jLabelPageStaff.setText("/" + String.valueOf(countStaff / 9 + setPageStaff));
        int pageStaff = (Integer.parseInt(jTextFieldPageStaff.getText()) - 1) * 9;
        u = ListUsers.get(pageStaff + 5);
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelEditStaff6MouseClicked

    private void jLabelEditStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseEntered
        // TODO add your handling code here:
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px_1.png")));
    }//GEN-LAST:event_jLabelEditStaff6MouseEntered

    private void jLabelEditStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStaff6MouseExited
        // TODO add your handling code here:
        jLabelEditStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_edit_20px.png")));
    }//GEN-LAST:event_jLabelEditStaff6MouseExited

    private void jLabelMessengerStaff6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff6MouseEntered
        // TODO add your handling code here:
        jLabelMessengerStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px_2.png")));
        jLabelMessengerStaff6.setForeground(new java.awt.Color(0, 142, 255));
    }//GEN-LAST:event_jLabelMessengerStaff6MouseEntered

    private void jLabelMessengerStaff6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMessengerStaff6MouseExited
        // TODO add your handling code here:
        jLabelMessengerStaff6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_facebook_messenger_20px.png")));
        jLabelMessengerStaff6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelMessengerStaff6MouseExited

    private void jLabelAvatarClick6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvatarClick6MouseClicked
        // TODO add your handling code here:
        popUpImageStaff(5);
    }//GEN-LAST:event_jLabelAvatarClick6MouseClicked

    private void jTextFieldPageStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageStaffKeyReleased
        try {
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPageStaffKeyReleased

    private void jLabelRight2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        int jlabelrightb = countStaff / 9 + setPageStaff;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageStaff.setText(String.valueOf(jlabelrighta + 1));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelRight2MouseClicked

    private void jLabelRight2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseEntered
        // TODO add your handling code here:
        jLabelRight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRight2MouseEntered

    private void jLabelRight2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRight2MouseExited
        // TODO add your handling code here:
        jLabelRight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRight2MouseExited

    private void jLabelLeft2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        if (Integer.parseInt(jTextFieldPageStaff.getText()) > 1) {
            jTextFieldPageStaff.setText(String.valueOf(jlabelrighta - 1));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeft2MouseClicked

    private void jLabelLeft2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft2MouseEntered
        // TODO add your handling code here:
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeft2MouseEntered

    private void jLabelLeft2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft2MouseExited
        // TODO add your handling code here:
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeft2MouseExited

    private void jLabelSkipToEnd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEnd2MouseClicked
        // TODO add your handling code here:
        int jlabelrighta = Integer.parseInt(jTextFieldPageStaff.getText());
        int jlabelrightb = countStaff / 9 + setPageStaff;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageStaff.setText(String.valueOf(countStaff / 9 + setPageStaff));
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEnd2MouseClicked

    private void jLabelSkipToEnd2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEnd2MouseEntered
        // TODO add your handling code here:
        jLabelSkipToEnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEnd2MouseEntered

    private void jLabelSkipToEnd2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEnd2MouseExited
        // TODO add your handling code here:
        jLabelSkipToEnd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEnd2MouseExited

    private void jLabelSkipToStart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStart2MouseClicked
        // TODO add your handling code here:
        if (Integer.parseInt(jTextFieldPageStaff.getText()) > 1) {
            jTextFieldPageStaff.setText("1");
            try {
                showStaffList(ListUsers, countStaff);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStart2MouseClicked

    private void jLabelSkipToStart2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStart2MouseEntered
        // TODO add your handling code here:
        jLabelSkipToStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStart2MouseEntered

    private void jLabelSkipToStart2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStart2MouseExited
        // TODO add your handling code here:
        jLabelSkipToStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStart2MouseExited

    private void jTextFieldSearchStaffFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffFocusGained
        jTextFieldSearchStaff.setText("");
    }//GEN-LAST:event_jTextFieldSearchStaffFocusGained

    private void jTextFieldSearchStaffFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffFocusLost
        if (jTextFieldSearchStaff.getText().equals("")) {
            jTextFieldSearchStaff.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchStaffFocusLost

    private void jTextFieldSearchStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchStaffKeyReleased

        String searchKey = jTextFieldSearchStaff.getText();

        try {
            ListUsers = UsersDao.searchStaff(searchKey);
            countStaff = UsersDao.countStaffSearch(searchKey);
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTextFieldSearchStaffKeyReleased

    private void jLabelButtonAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddStaffMouseClicked
        EditStaff es = new EditStaff(null, "Thêm nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelButtonAddStaffMouseClicked

    private void jLabelButtonAddStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonAddStaffMouseEntered

    private void jLabelButtonAddStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonAddStaffMouseExited
        jLabelBBButtonAddStaff.setIcon(scaleButtonAddStaff("/Image/ButtonEditBlue.png"));
    }//GEN-LAST:event_jLabelButtonAddStaffMouseExited

    private void jLabelButtonRefreshStaffListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseClicked
        try {
            ListUsers = UsersDao.findStaff();
            countStaff = UsersDao.countStaff();
            showStaffList(ListUsers, countStaff);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseClicked

    private void jLabelButtonRefreshStaffListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseEntered

    private void jLabelButtonRefreshStaffListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshStaffListMouseExited
        jLabelBBButtonRefreshStaffList.setIcon(scaleButtonRefresh("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonRefreshStaffListMouseExited

    private void jLabelButtonDeleteStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonDeleteStaffMouseClicked
        ConfirmDeleteStaff cd = new ConfirmDeleteStaff(u);
        cd.setVisible(true);
        cd.pack();
    }//GEN-LAST:event_jLabelButtonDeleteStaffMouseClicked

    private void jLabelButtonDeleteStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonDeleteStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
        jLabelButtonDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
        jLabelButtonDeleteStaff.setForeground(new java.awt.Color(255, 92, 92));
    }//GEN-LAST:event_jLabelButtonDeleteStaffMouseEntered

    private void jLabelButtonDeleteStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonDeleteStaffMouseExited
        // TODO add your handling code here:
        jLabelBBButtonDeleteStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
        jLabelButtonDeleteStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
        jLabelButtonDeleteStaff.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelButtonDeleteStaffMouseExited

    private void jLabelButtonStatusStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonStatusStaffMouseClicked
        ConfirmOperations co = new ConfirmOperations(u);
        co.setVisible(true);
        co.pack();
    }//GEN-LAST:event_jLabelButtonStatusStaffMouseClicked

    private void jLabelButtonStatusStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonStatusStaffMouseEntered
        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonStatusStaffMouseEntered

    private void jLabelButtonStatusStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonStatusStaffMouseExited
        jLabelBBButtonStatusStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonStatusStaffMouseExited

    private void jLabelButtonEditStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseClicked
        EditStaff es = new EditStaff(u, "Sửa thông tin nhân viên");
        es.setVisible(true);
        es.pack();
    }//GEN-LAST:event_jLabelButtonEditStaffMouseClicked

    private void jLabelButtonEditStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseEntered
        // TODO add your handling code here:
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditDark.png"));
    }//GEN-LAST:event_jLabelButtonEditStaffMouseEntered

    private void jLabelButtonEditStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonEditStaffMouseExited
        // TODO add your handling code here:
        jLabelBBButtonEditStaff.setIcon(scaleButtonEdit("/Image/ButtonEditLight.png"));
    }//GEN-LAST:event_jLabelButtonEditStaffMouseExited

    private void jLabelFrameAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFrameAvatarMouseClicked
        // TODO add your handling code here:
        //        popUpImageStaff(thisStaff);
    }//GEN-LAST:event_jLabelFrameAvatarMouseClicked

    private void jLabelPreviousYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseClicked
        // TODO add your handling code here:
        selectedYear--;
        try {
            showCalendar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelInforStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelPreviousYearMouseClicked

    private void jLabelPreviousYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseEntered
        // TODO add your handling code here:
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px_1.png")));
    }//GEN-LAST:event_jLabelPreviousYearMouseEntered

    private void jLabelPreviousYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousYearMouseExited
        // TODO add your handling code here:
        jLabelPreviousYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_down_40px.png")));
    }//GEN-LAST:event_jLabelPreviousYearMouseExited

    private void jLabelNextYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseClicked
        // TODO add your handling code here:
        selectedYear++;
        try {
            showCalendar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelInforStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelNextYearMouseClicked

    private void jLabelNextYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseEntered
        // TODO add your handling code here:
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px_1.png")));
    }//GEN-LAST:event_jLabelNextYearMouseEntered

    private void jLabelNextYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextYearMouseExited
        // TODO add your handling code here:
        jLabelNextYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_up_40px.png")));
    }//GEN-LAST:event_jLabelNextYearMouseExited

    private void jLabelPreviousMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseClicked
        // TODO add your handling code here:
        if (selectedMonth == 0) {
            selectedMonth = 11;
            selectedYear--;
        } else {
            selectedMonth--;
        }
        try {
            showCalendar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelInforStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelPreviousMonthMouseClicked

    private void jLabelPreviousMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseEntered
        // TODO add your handling code here:
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px_1.png")));
    }//GEN-LAST:event_jLabelPreviousMonthMouseEntered

    private void jLabelPreviousMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPreviousMonthMouseExited
        // TODO add your handling code here:
        jLabelPreviousMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_left_40px.png")));
    }//GEN-LAST:event_jLabelPreviousMonthMouseExited

    private void jLabelNextMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseClicked
        // TODO add your handling code here:
        if (selectedMonth == 11) {
            selectedMonth = 0;
            selectedYear++;
        } else {
            selectedMonth++;
        }
        try {
            showCalendar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PanelInforStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelNextMonthMouseClicked

    private void jLabelNextMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseEntered
        // TODO add your handling code here:
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px_1.png")));
    }//GEN-LAST:event_jLabelNextMonthMouseEntered

    private void jLabelNextMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNextMonthMouseExited
        // TODO add your handling code here:
        jLabelNextMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_chevron_right_40px.png")));
    }//GEN-LAST:event_jLabelNextMonthMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDashboardQLNV;
    private javax.swing.JLabel jLabelAddressStaff1;
    private javax.swing.JLabel jLabelAddressStaff2;
    private javax.swing.JLabel jLabelAddressStaff3;
    private javax.swing.JLabel jLabelAddressStaff4;
    private javax.swing.JLabel jLabelAddressStaff5;
    private javax.swing.JLabel jLabelAddressStaff6;
    private javax.swing.JLabel jLabelAddressStaff7;
    private javax.swing.JLabel jLabelAddressStaff8;
    private javax.swing.JLabel jLabelAddressStaff9;
    private javax.swing.JLabel jLabelAvatar1;
    private javax.swing.JLabel jLabelAvatar2;
    private javax.swing.JLabel jLabelAvatar3;
    private javax.swing.JLabel jLabelAvatar4;
    private javax.swing.JLabel jLabelAvatar5;
    private javax.swing.JLabel jLabelAvatar6;
    private javax.swing.JLabel jLabelAvatar7;
    private javax.swing.JLabel jLabelAvatar8;
    private javax.swing.JLabel jLabelAvatar9;
    private javax.swing.JLabel jLabelAvatarClick1;
    private javax.swing.JLabel jLabelAvatarClick2;
    private javax.swing.JLabel jLabelAvatarClick3;
    private javax.swing.JLabel jLabelAvatarClick4;
    private javax.swing.JLabel jLabelAvatarClick5;
    private javax.swing.JLabel jLabelAvatarClick6;
    private javax.swing.JLabel jLabelAvatarClick7;
    private javax.swing.JLabel jLabelAvatarClick8;
    private javax.swing.JLabel jLabelAvatarClick9;
    private javax.swing.JLabel jLabelAvatarStaff;
    private javax.swing.JLabel jLabelBBButtonAddStaff;
    private javax.swing.JLabel jLabelBBButtonDeleteStaff;
    private javax.swing.JLabel jLabelBBButtonEditStaff;
    private javax.swing.JLabel jLabelBBButtonRefreshStaffList;
    private javax.swing.JLabel jLabelBBButtonStatusStaff;
    private javax.swing.JLabel jLabelButtonAddStaff;
    private javax.swing.JLabel jLabelButtonDeleteStaff;
    private javax.swing.JLabel jLabelButtonEditStaff;
    private javax.swing.JLabel jLabelButtonRefreshStaffList;
    private javax.swing.JLabel jLabelButtonStatusStaff;
    private javax.swing.JLabel jLabelDayCalendar1;
    private javax.swing.JLabel jLabelDayCalendar10;
    private javax.swing.JLabel jLabelDayCalendar11;
    private javax.swing.JLabel jLabelDayCalendar12;
    private javax.swing.JLabel jLabelDayCalendar13;
    private javax.swing.JLabel jLabelDayCalendar14;
    private javax.swing.JLabel jLabelDayCalendar15;
    private javax.swing.JLabel jLabelDayCalendar16;
    private javax.swing.JLabel jLabelDayCalendar17;
    private javax.swing.JLabel jLabelDayCalendar18;
    private javax.swing.JLabel jLabelDayCalendar19;
    private javax.swing.JLabel jLabelDayCalendar2;
    private javax.swing.JLabel jLabelDayCalendar20;
    private javax.swing.JLabel jLabelDayCalendar21;
    private javax.swing.JLabel jLabelDayCalendar22;
    private javax.swing.JLabel jLabelDayCalendar23;
    private javax.swing.JLabel jLabelDayCalendar24;
    private javax.swing.JLabel jLabelDayCalendar25;
    private javax.swing.JLabel jLabelDayCalendar26;
    private javax.swing.JLabel jLabelDayCalendar27;
    private javax.swing.JLabel jLabelDayCalendar28;
    private javax.swing.JLabel jLabelDayCalendar29;
    private javax.swing.JLabel jLabelDayCalendar3;
    private javax.swing.JLabel jLabelDayCalendar30;
    private javax.swing.JLabel jLabelDayCalendar31;
    private javax.swing.JLabel jLabelDayCalendar32;
    private javax.swing.JLabel jLabelDayCalendar33;
    private javax.swing.JLabel jLabelDayCalendar34;
    private javax.swing.JLabel jLabelDayCalendar35;
    private javax.swing.JLabel jLabelDayCalendar36;
    private javax.swing.JLabel jLabelDayCalendar37;
    private javax.swing.JLabel jLabelDayCalendar38;
    private javax.swing.JLabel jLabelDayCalendar39;
    private javax.swing.JLabel jLabelDayCalendar4;
    private javax.swing.JLabel jLabelDayCalendar40;
    private javax.swing.JLabel jLabelDayCalendar41;
    private javax.swing.JLabel jLabelDayCalendar42;
    private javax.swing.JLabel jLabelDayCalendar43;
    private javax.swing.JLabel jLabelDayCalendar44;
    private javax.swing.JLabel jLabelDayCalendar45;
    private javax.swing.JLabel jLabelDayCalendar46;
    private javax.swing.JLabel jLabelDayCalendar47;
    private javax.swing.JLabel jLabelDayCalendar48;
    private javax.swing.JLabel jLabelDayCalendar49;
    private javax.swing.JLabel jLabelDayCalendar5;
    private javax.swing.JLabel jLabelDayCalendar6;
    private javax.swing.JLabel jLabelDayCalendar7;
    private javax.swing.JLabel jLabelDayCalendar8;
    private javax.swing.JLabel jLabelDayCalendar9;
    private javax.swing.JLabel jLabelDeleteStaff1;
    private javax.swing.JLabel jLabelDeleteStaff2;
    private javax.swing.JLabel jLabelDeleteStaff3;
    private javax.swing.JLabel jLabelDeleteStaff4;
    private javax.swing.JLabel jLabelDeleteStaff5;
    private javax.swing.JLabel jLabelDeleteStaff6;
    private javax.swing.JLabel jLabelDeleteStaff7;
    private javax.swing.JLabel jLabelDeleteStaff8;
    private javax.swing.JLabel jLabelDeleteStaff9;
    private javax.swing.JLabel jLabelEditStaff1;
    private javax.swing.JLabel jLabelEditStaff2;
    private javax.swing.JLabel jLabelEditStaff3;
    private javax.swing.JLabel jLabelEditStaff4;
    private javax.swing.JLabel jLabelEditStaff5;
    private javax.swing.JLabel jLabelEditStaff6;
    private javax.swing.JLabel jLabelEditStaff7;
    private javax.swing.JLabel jLabelEditStaff8;
    private javax.swing.JLabel jLabelEditStaff9;
    private javax.swing.JLabel jLabelEmailStaff1;
    private javax.swing.JLabel jLabelEmailStaff2;
    private javax.swing.JLabel jLabelEmailStaff3;
    private javax.swing.JLabel jLabelEmailStaff4;
    private javax.swing.JLabel jLabelEmailStaff5;
    private javax.swing.JLabel jLabelEmailStaff6;
    private javax.swing.JLabel jLabelEmailStaff7;
    private javax.swing.JLabel jLabelEmailStaff8;
    private javax.swing.JLabel jLabelEmailStaff9;
    private javax.swing.JLabel jLabelFrameAvatar;
    private javax.swing.JLabel jLabelFrameSearchStaff;
    private javax.swing.JLabel jLabelFrameStaff1;
    private javax.swing.JLabel jLabelFrameStaff2;
    private javax.swing.JLabel jLabelFrameStaff3;
    private javax.swing.JLabel jLabelFrameStaff4;
    private javax.swing.JLabel jLabelFrameStaff5;
    private javax.swing.JLabel jLabelFrameStaff6;
    private javax.swing.JLabel jLabelFrameStaff7;
    private javax.swing.JLabel jLabelFrameStaff8;
    private javax.swing.JLabel jLabelFrameStaff9;
    private javax.swing.JLabel jLabelGenderStaff1;
    private javax.swing.JLabel jLabelGenderStaff2;
    private javax.swing.JLabel jLabelGenderStaff3;
    private javax.swing.JLabel jLabelGenderStaff4;
    private javax.swing.JLabel jLabelGenderStaff5;
    private javax.swing.JLabel jLabelGenderStaff6;
    private javax.swing.JLabel jLabelGenderStaff7;
    private javax.swing.JLabel jLabelGenderStaff8;
    private javax.swing.JLabel jLabelGenderStaff9;
    private javax.swing.JLabel jLabelInformationAddress;
    private javax.swing.JLabel jLabelInformationAddress1;
    private javax.swing.JLabel jLabelInformationAllowance;
    private javax.swing.JLabel jLabelInformationAllowance1;
    private javax.swing.JLabel jLabelInformationBasicsalary;
    private javax.swing.JLabel jLabelInformationBasicsalary1;
    private javax.swing.JLabel jLabelInformationBirthday;
    private javax.swing.JLabel jLabelInformationBirthday1;
    private javax.swing.JLabel jLabelInformationEmail;
    private javax.swing.JLabel jLabelInformationEmail1;
    private javax.swing.JLabel jLabelInformationGender;
    private javax.swing.JLabel jLabelInformationGender1;
    private javax.swing.JLabel jLabelInformationId;
    private javax.swing.JLabel jLabelInformationId1;
    private javax.swing.JLabel jLabelInformationNameStaff;
    private javax.swing.JLabel jLabelInformationPhonenumber;
    private javax.swing.JLabel jLabelInformationPhonenumber1;
    private javax.swing.JLabel jLabelInformationStartdate;
    private javax.swing.JLabel jLabelInformationStartdate1;
    private javax.swing.JLabel jLabelInformationUsername;
    private javax.swing.JLabel jLabelInformationUsername1;
    private javax.swing.JLabel jLabelLeft2;
    private javax.swing.JLabel jLabelMessengerStaff1;
    private javax.swing.JLabel jLabelMessengerStaff2;
    private javax.swing.JLabel jLabelMessengerStaff3;
    private javax.swing.JLabel jLabelMessengerStaff4;
    private javax.swing.JLabel jLabelMessengerStaff5;
    private javax.swing.JLabel jLabelMessengerStaff6;
    private javax.swing.JLabel jLabelMessengerStaff7;
    private javax.swing.JLabel jLabelMessengerStaff8;
    private javax.swing.JLabel jLabelMessengerStaff9;
    private javax.swing.JLabel jLabelNameCalendar;
    private javax.swing.JLabel jLabelNameStaff1;
    private javax.swing.JLabel jLabelNameStaff2;
    private javax.swing.JLabel jLabelNameStaff3;
    private javax.swing.JLabel jLabelNameStaff4;
    private javax.swing.JLabel jLabelNameStaff5;
    private javax.swing.JLabel jLabelNameStaff6;
    private javax.swing.JLabel jLabelNameStaff7;
    private javax.swing.JLabel jLabelNameStaff8;
    private javax.swing.JLabel jLabelNameStaff9;
    private javax.swing.JLabel jLabelNextMonth;
    private javax.swing.JLabel jLabelNextYear;
    private javax.swing.JLabel jLabelNumberOfSalary;
    private javax.swing.JLabel jLabelNumberOfStatistical;
    private javax.swing.JLabel jLabelNumberOfWorking;
    private javax.swing.JLabel jLabelPageStaff;
    private javax.swing.JLabel jLabelPreviousMonth;
    private javax.swing.JLabel jLabelPreviousYear;
    private javax.swing.JLabel jLabelRight2;
    private javax.swing.JLabel jLabelSearchStaff;
    private javax.swing.JLabel jLabelSkipToEnd2;
    private javax.swing.JLabel jLabelSkipToStart2;
    private javax.swing.JLabel jLabelStatusStaff1;
    private javax.swing.JLabel jLabelStatusStaff2;
    private javax.swing.JLabel jLabelStatusStaff3;
    private javax.swing.JLabel jLabelStatusStaff4;
    private javax.swing.JLabel jLabelStatusStaff5;
    private javax.swing.JLabel jLabelStatusStaff6;
    private javax.swing.JLabel jLabelStatusStaff7;
    private javax.swing.JLabel jLabelStatusStaff8;
    private javax.swing.JLabel jLabelStatusStaff9;
    private javax.swing.JLabel jLabelTT;
    private javax.swing.JLabel jLabelTitleQLNV;
    private javax.swing.JLabel jLabelTitleStatistical;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelControlPageStaff;
    private javax.swing.JPanel jPanelInformationStaff;
    private javax.swing.JPanel jPanelList;
    private javax.swing.JPanel jPanelStaff1;
    private javax.swing.JPanel jPanelStaff2;
    private javax.swing.JPanel jPanelStaff3;
    private javax.swing.JPanel jPanelStaff4;
    private javax.swing.JPanel jPanelStaff5;
    private javax.swing.JPanel jPanelStaff6;
    private javax.swing.JPanel jPanelStaff7;
    private javax.swing.JPanel jPanelStaff8;
    private javax.swing.JPanel jPanelStaff9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextFieldPageStaff;
    private javax.swing.JTextField jTextFieldSearchStaff;
    // End of variables declaration//GEN-END:variables
}
