/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.views.staff;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import qlbhgg.dao.GoodsDao;
import qlbhgg.models.Goods;
import qlbhgg.models.Invoicedetails;
import qlbhgg.views.admin.AdminForm;

/**
 *
 * @author acer
 */
public class PanelSale extends javax.swing.JPanel {

    /**
     * Creates new form PanelSale
     */
    public ArrayList<Goods> ListGoodsSale = GoodsDao.findAll();
    public ArrayList<Invoicedetails> ListBill1 = new ArrayList<>();
    public int countProductSale = GoodsDao.countProduct(), countProductBill;
    public int setPageProductSale, setPageBill;
    public int NumOrder = 1;

    public PanelSale() throws SQLException {
        initComponents();
        jLabelFrameSearchBill1.setIcon(scaleFrameSearch("/Image/FrameSearch.png"));
        showProductsSale(ListGoodsSale, countProductSale);
        showProductsBill(ListBill1, countProductBill);
    }

    public void startingStateQLBH() {
        jPanelProduct1.setVisible(false);
        jPanelProduct2.setVisible(false);
        jPanelProduct3.setVisible(false);
        jPanelProduct4.setVisible(false);
        jPanelProduct5.setVisible(false);
        jPanelProduct6.setVisible(false);
        jPanelProduct7.setVisible(false);
        jPanelProduct8.setVisible(false);
        jPanelProduct9.setVisible(false);
        jPanelProduct10.setVisible(false);
        jPanelProduct11.setVisible(false);
        jPanelProduct12.setVisible(false);
        jLabelOver1.setVisible(false);
        jLabelOver2.setVisible(false);
        jLabelOver3.setVisible(false);
        jLabelOver4.setVisible(false);
        jLabelOver5.setVisible(false);
        jLabelOver6.setVisible(false);
        jLabelOver7.setVisible(false);
        jLabelOver8.setVisible(false);
        jLabelOver9.setVisible(false);
        jLabelOver10.setVisible(false);
        jLabelOver11.setVisible(false);
        jLabelOver12.setVisible(false);
    }

    public void startingStateShowBill() {
        jPanelRowBill1.setVisible(false);
        jPanelRowBill2.setVisible(false);
        jPanelRowBill3.setVisible(false);
        jPanelRowBill4.setVisible(false);
        jPanelRowBill5.setVisible(false);
        jPanelRowBill6.setVisible(false);
        jPanelRowBill7.setVisible(false);
        jPanelRowBill8.setVisible(false);
    }

    private void showProductsSale(ArrayList<Goods> ListGoodsSale, int countProductSale) throws SQLException {
        startingStateQLBH();
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;

        if (pageProductSale < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale), jPanelProduct1, jLabelOver1, jLabelImageProduct1, jLabelNameProduct1, jLabelPriceProduct1);
        } else {
            jPanelProduct1.setVisible(false);
        }
        if (pageProductSale + 1 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 1), jPanelProduct2, jLabelOver2, jLabelImageProduct2, jLabelNameProduct2, jLabelPriceProduct2);
        } else {
            jPanelProduct2.setVisible(false);
        }
        if (pageProductSale + 2 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 2), jPanelProduct3, jLabelOver3, jLabelImageProduct3, jLabelNameProduct3, jLabelPriceProduct3);
        } else {
            jPanelProduct2.setVisible(false);
        }
        if (pageProductSale + 3 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 3), jPanelProduct4, jLabelOver4, jLabelImageProduct4, jLabelNameProduct4, jLabelPriceProduct4);
        } else {
            jPanelProduct4.setVisible(false);
        }
        if (pageProductSale + 4 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 4), jPanelProduct5, jLabelOver5, jLabelImageProduct5, jLabelNameProduct5, jLabelPriceProduct5);
        } else {
            jPanelProduct5.setVisible(false);
        }
        if (pageProductSale + 5 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 5), jPanelProduct6, jLabelOver6, jLabelImageProduct6, jLabelNameProduct6, jLabelPriceProduct6);
        } else {
            jPanelProduct6.setVisible(false);
        }
        if (pageProductSale + 6 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 6), jPanelProduct7, jLabelOver7, jLabelImageProduct7, jLabelNameProduct7, jLabelPriceProduct7);
        } else {
            jPanelProduct7.setVisible(false);
        }
        if (pageProductSale + 7 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 7), jPanelProduct8, jLabelOver8, jLabelImageProduct8, jLabelNameProduct8, jLabelPriceProduct8);
        } else {
            jPanelProduct8.setVisible(false);
        }
        if (pageProductSale + 8 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 8), jPanelProduct9, jLabelOver9, jLabelImageProduct9, jLabelNameProduct9, jLabelPriceProduct9);
        } else {
            jPanelProduct9.setVisible(false);
        }
        if (pageProductSale + 9 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 9), jPanelProduct10, jLabelOver10, jLabelImageProduct10, jLabelNameProduct10, jLabelPriceProduct10);
        } else {
            jPanelProduct10.setVisible(false);
        }
        if (pageProductSale + 10 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 10), jPanelProduct11, jLabelOver11, jLabelImageProduct11, jLabelNameProduct11, jLabelPriceProduct11);
        } else {
            jPanelProduct11.setVisible(false);
        }
        if (pageProductSale + 11 < countProductSale) {
            renderJPanelGoodSale(ListGoodsSale.get(pageProductSale + 11), jPanelProduct12, jLabelOver12, jLabelImageProduct12, jLabelNameProduct12, jLabelPriceProduct12);
        } else {
            jPanelProduct12.setVisible(false);
        }
    }

    private void showProductsBill(ArrayList<Invoicedetails> ListBill, int countProductBill) throws SQLException {
        startingStateShowBill();
        if (ListBill.size() > 0) {
            countProductBill = ListBill.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;

            if (pageBill < countProductBill) {
                renderJPanelBill(pageBill + 1, ListBill.get(pageBill), jPanelRowBill1, jLabelNumOrder1, jLabelImage1, jLabelName1, jLabelTotalPrice1, jTextFieldPrice1, jTextFieldAmount1, jTextFieldDiscount1);
            } else {
                jPanelRowBill1.setVisible(false);
            }
            if (pageBill + 1 < countProductBill) {
                renderJPanelBill(pageBill + 2, ListBill.get(pageBill + 1), jPanelRowBill2, jLabelNumOrder2, jLabelImage2, jLabelName2, jLabelTotalPrice2, jTextFieldPrice2, jTextFieldAmount2, jTextFieldDiscount2);
            } else {
                jPanelRowBill2.setVisible(false);
            }
            if (pageBill + 2 < countProductBill) {
                renderJPanelBill(pageBill + 3, ListBill.get(pageBill + 2), jPanelRowBill3, jLabelNumOrder3, jLabelImage3, jLabelName3, jLabelTotalPrice3, jTextFieldPrice3, jTextFieldAmount3, jTextFieldDiscount3);
            } else {
                jPanelRowBill3.setVisible(false);
            }
            if (pageBill + 3 < countProductBill) {
                renderJPanelBill(pageBill + 4, ListBill.get(pageBill + 3), jPanelRowBill4, jLabelNumOrder4, jLabelImage4, jLabelName4, jLabelTotalPrice4, jTextFieldPrice4, jTextFieldAmount4, jTextFieldDiscount4);
            } else {
                jPanelRowBill4.setVisible(false);
            }
            if (pageBill + 4 < countProductBill) {
                renderJPanelBill(pageBill + 5, ListBill.get(pageBill + 4), jPanelRowBill5, jLabelNumOrder5, jLabelImage5, jLabelName5, jLabelTotalPrice5, jTextFieldPrice5, jTextFieldAmount5, jTextFieldDiscount5);
            } else {
                jPanelRowBill5.setVisible(false);
            }
            if (pageBill + 5 < countProductBill) {
                renderJPanelBill(pageBill + 6, ListBill.get(pageBill + 5), jPanelRowBill6, jLabelNumOrder6, jLabelImage6, jLabelName6, jLabelTotalPrice6, jTextFieldPrice6, jTextFieldAmount6, jTextFieldDiscount6);
            } else {
                jPanelRowBill6.setVisible(false);
            }
            if (pageBill + 6 < countProductBill) {
                renderJPanelBill(pageBill + 7, ListBill.get(pageBill + 6), jPanelRowBill7, jLabelNumOrder7, jLabelImage7, jLabelName7, jLabelTotalPrice7, jTextFieldPrice7, jTextFieldAmount7, jTextFieldDiscount7);
            } else {
                jPanelRowBill7.setVisible(false);
            }
            if (pageBill + 7 < countProductBill) {
                renderJPanelBill(pageBill + 7, ListBill.get(pageBill + 7), jPanelRowBill8, jLabelNumOrder8, jLabelImage8, jLabelName8, jLabelTotalPrice8, jTextFieldPrice8, jTextFieldAmount8, jTextFieldDiscount8);
            } else {
                jPanelRowBill8.setVisible(false);
            }
            float totalPrice = 0, totalDiscount = 0;
            for (Invoicedetails invoicedetails : ListBill) {
                totalPrice += invoicedetails.getPrice() * invoicedetails.getAmount();
                totalDiscount += (invoicedetails.getPrice() / 100) * invoicedetails.getDiscount() * invoicedetails.getAmount();
            }
            jLabelTotalPriceBill.setText(String.format("%1$,.0f", totalPrice));
            jLabelDiscountBill.setText(String.format("%1$,.0f", totalDiscount));
            jLabelCustomerNeedPay.setText(String.format("%1$,.0f", totalPrice - totalDiscount));
        }
    }

    private void renderJPanelBill(int stt, Invoicedetails i, JPanel jpanel, JLabel jlabelNumOrder, JLabel jlabelImage, JLabel jlabelName, JLabel jlabelTotalPrice, JTextField jtextfieldPrice, JTextField jtextfieldAmount, JTextField jtextfieldDiscount) throws SQLException {
        jpanel.setVisible(true);
        jpanel.setEnabled(true);
        Goods g = GoodsDao.findProductForBill(i.getItemcode());
        jlabelNumOrder.setText(String.valueOf(stt));
        jlabelImage.setIcon(scaleItemBill(g.getImageitem()));
        jlabelName.setText("<html>" + g.getItemname() + "</html>");
        jtextfieldPrice.setText(String.format("%1$,.0f", g.getPrice()));
        jtextfieldAmount.setText(String.valueOf(i.getAmount()));
        jlabelTotalPrice.setText(String.format("%1$,.0f", i.getPrice() * i.getAmount()));
        jtextfieldDiscount.setText(String.valueOf(i.getDiscount()));
    }

    private void renderJPanelGoodSale(Goods g, JPanel jpanel, JLabel jlabelOver, JLabel jlabelImage, JLabel jlabelName, JLabel jlabelPrice) {
        jpanel.setVisible(true);
        jpanel.setEnabled(true);
        if (g.getAmount() == 0) {
            jlabelOver.setVisible(true);
        } else {
            jlabelOver.setVisible(false);
        }
        jlabelImage.setIcon(scaleImageProduct(g.getImageitem()));
        String productName = "<html>" + g.getItemname() + "</html>";
        jlabelName.setText(productName);
        jlabelPrice.setText(String.format("%1$,.0f", g.getPrice()));
    }

    public ImageIcon scaleFrameSearch(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(280, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public ImageIcon scaleItemBill(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public ImageIcon scaleImageProduct(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    public ImageIcon scaleFrameBill(String path) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(118, 31, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jDashboardQLBH = new javax.swing.JPanel();
        jPanelSelectedProduct = new javax.swing.JPanel();
        jPanelShowBill = new javax.swing.JPanel();
        jPanelRowBill8 = new javax.swing.JPanel();
        jLabelNumOrder8 = new javax.swing.JLabel();
        jLabelImage8 = new javax.swing.JLabel();
        jLabelName8 = new javax.swing.JLabel();
        jLabelTotalPrice8 = new javax.swing.JLabel();
        jLabelDelete8 = new javax.swing.JLabel();
        jTextFieldPrice8 = new javax.swing.JTextField();
        jTextFieldAmount8 = new javax.swing.JTextField();
        jTextFieldDiscount8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelAddAmount8 = new javax.swing.JLabel();
        jLabelMinusAmount8 = new javax.swing.JLabel();
        jPanelRowBill7 = new javax.swing.JPanel();
        jLabelNumOrder7 = new javax.swing.JLabel();
        jLabelImage7 = new javax.swing.JLabel();
        jLabelName7 = new javax.swing.JLabel();
        jLabelTotalPrice7 = new javax.swing.JLabel();
        jLabelDelete7 = new javax.swing.JLabel();
        jTextFieldPrice7 = new javax.swing.JTextField();
        jTextFieldAmount7 = new javax.swing.JTextField();
        jTextFieldDiscount7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelAddAmount7 = new javax.swing.JLabel();
        jLabelMinusAmount7 = new javax.swing.JLabel();
        jPanelRowBill6 = new javax.swing.JPanel();
        jLabelNumOrder6 = new javax.swing.JLabel();
        jLabelImage6 = new javax.swing.JLabel();
        jLabelName6 = new javax.swing.JLabel();
        jLabelTotalPrice6 = new javax.swing.JLabel();
        jLabelDelete6 = new javax.swing.JLabel();
        jTextFieldPrice6 = new javax.swing.JTextField();
        jTextFieldAmount6 = new javax.swing.JTextField();
        jTextFieldDiscount6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelAddAmount6 = new javax.swing.JLabel();
        jLabelMinusAmount6 = new javax.swing.JLabel();
        jPanelRowBill5 = new javax.swing.JPanel();
        jLabelNumOrder5 = new javax.swing.JLabel();
        jLabelImage5 = new javax.swing.JLabel();
        jLabelName5 = new javax.swing.JLabel();
        jLabelTotalPrice5 = new javax.swing.JLabel();
        jLabelDelete5 = new javax.swing.JLabel();
        jTextFieldPrice5 = new javax.swing.JTextField();
        jTextFieldAmount5 = new javax.swing.JTextField();
        jTextFieldDiscount5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelAddAmount5 = new javax.swing.JLabel();
        jLabelMinusAmount5 = new javax.swing.JLabel();
        jPanelRowBill4 = new javax.swing.JPanel();
        jLabelNumOrder4 = new javax.swing.JLabel();
        jLabelImage4 = new javax.swing.JLabel();
        jLabelName4 = new javax.swing.JLabel();
        jLabelTotalPrice4 = new javax.swing.JLabel();
        jLabelDelete4 = new javax.swing.JLabel();
        jTextFieldPrice4 = new javax.swing.JTextField();
        jTextFieldAmount4 = new javax.swing.JTextField();
        jTextFieldDiscount4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelAddAmount4 = new javax.swing.JLabel();
        jLabelMinusAmount4 = new javax.swing.JLabel();
        jPanelRowBill3 = new javax.swing.JPanel();
        jLabelNumOrder3 = new javax.swing.JLabel();
        jLabelImage3 = new javax.swing.JLabel();
        jLabelName3 = new javax.swing.JLabel();
        jLabelTotalPrice3 = new javax.swing.JLabel();
        jLabelDelete3 = new javax.swing.JLabel();
        jTextFieldPrice3 = new javax.swing.JTextField();
        jTextFieldAmount3 = new javax.swing.JTextField();
        jTextFieldDiscount3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelAddAmount3 = new javax.swing.JLabel();
        jLabelMinusAmount3 = new javax.swing.JLabel();
        jPanelRowBill2 = new javax.swing.JPanel();
        jLabelNumOrder2 = new javax.swing.JLabel();
        jLabelImage2 = new javax.swing.JLabel();
        jLabelName2 = new javax.swing.JLabel();
        jLabelTotalPrice2 = new javax.swing.JLabel();
        jLabelDelete2 = new javax.swing.JLabel();
        jTextFieldPrice2 = new javax.swing.JTextField();
        jTextFieldAmount2 = new javax.swing.JTextField();
        jTextFieldDiscount2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelAddAmount2 = new javax.swing.JLabel();
        jLabelMinusAmount2 = new javax.swing.JLabel();
        jPanelRowBill1 = new javax.swing.JPanel();
        jLabelNumOrder1 = new javax.swing.JLabel();
        jLabelImage1 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jLabelTotalPrice1 = new javax.swing.JLabel();
        jLabelDelete1 = new javax.swing.JLabel();
        jTextFieldDiscount1 = new javax.swing.JTextField();
        jTextFieldAmount1 = new javax.swing.JTextField();
        jTextFieldPrice1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelMinusAmount1 = new javax.swing.JLabel();
        jLabelAddAmount1 = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelNumOrder = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelDiscount = new javax.swing.JLabel();
        jLabelTotalPrice = new javax.swing.JLabel();
        jLabelPrice = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jPanelControlPageBill2 = new javax.swing.JPanel();
        jTextFieldPageBill2 = new javax.swing.JTextField();
        jLabelPageBill2 = new javax.swing.JLabel();
        jLabelRightPageBill2 = new javax.swing.JLabel();
        jLabelLeftPageBill2 = new javax.swing.JLabel();
        jLabelSkipToEndPageBill2 = new javax.swing.JLabel();
        jLabelSkipToStartPageBill2 = new javax.swing.JLabel();
        jPanelPay = new javax.swing.JPanel();
        jLabelStaff2 = new javax.swing.JLabel();
        jLabelStaff1 = new javax.swing.JLabel();
        jLabelStaff = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldCustomerPay = new javax.swing.JTextField();
        jLabelTotalPriceBill = new javax.swing.JLabel();
        jLabelDiscountBill1 = new javax.swing.JLabel();
        jLabelDiscountBill = new javax.swing.JLabel();
        jLabelCustomerNeedPay = new javax.swing.JLabel();
        jLabelCustomerPay = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelExcessCash = new javax.swing.JLabel();
        jTextFieldNote = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jLabelTotalPriceBill1 = new javax.swing.JLabel();
        jLabelDiscountBill2 = new javax.swing.JLabel();
        jTextFieldMoreDiscount = new javax.swing.JTextField();
        jLabelCustomerNeedPay1 = new javax.swing.JLabel();
        jLabelExcessCash1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanelSelectProduct = new javax.swing.JPanel();
        jPanelControlPageBill1 = new javax.swing.JPanel();
        jTextFieldPageBill1 = new javax.swing.JTextField();
        jLabelPageBill1 = new javax.swing.JLabel();
        jLabelRightPageBill1 = new javax.swing.JLabel();
        jLabelLeftPageBill1 = new javax.swing.JLabel();
        jLabelSkipToEndPageBill1 = new javax.swing.JLabel();
        jLabelSkipToStartPageBill1 = new javax.swing.JLabel();
        jLabelSearchBill1 = new javax.swing.JLabel();
        jTextFieldSearchBill1 = new javax.swing.JTextField();
        jLabelFrameSearchBill1 = new javax.swing.JLabel();
        jPanelProduct12 = new javax.swing.JPanel();
        jLabelOver12 = new javax.swing.JLabel();
        jLabelImageProduct12 = new javax.swing.JLabel();
        jLabelNameProduct12 = new javax.swing.JLabel();
        jLabelPriceProduct12 = new javax.swing.JLabel();
        jLabelAdd12 = new javax.swing.JLabel();
        jPanelProduct11 = new javax.swing.JPanel();
        jLabelOver11 = new javax.swing.JLabel();
        jLabelImageProduct11 = new javax.swing.JLabel();
        jLabelNameProduct11 = new javax.swing.JLabel();
        jLabelPriceProduct11 = new javax.swing.JLabel();
        jLabelAdd11 = new javax.swing.JLabel();
        jPanelProduct10 = new javax.swing.JPanel();
        jLabelOver10 = new javax.swing.JLabel();
        jLabelImageProduct10 = new javax.swing.JLabel();
        jLabelNameProduct10 = new javax.swing.JLabel();
        jLabelPriceProduct10 = new javax.swing.JLabel();
        jLabelAdd10 = new javax.swing.JLabel();
        jPanelProduct9 = new javax.swing.JPanel();
        jLabelOver9 = new javax.swing.JLabel();
        jLabelImageProduct9 = new javax.swing.JLabel();
        jLabelNameProduct9 = new javax.swing.JLabel();
        jLabelPriceProduct9 = new javax.swing.JLabel();
        jLabelAdd9 = new javax.swing.JLabel();
        jPanelProduct8 = new javax.swing.JPanel();
        jLabelOver8 = new javax.swing.JLabel();
        jLabelImageProduct8 = new javax.swing.JLabel();
        jLabelNameProduct8 = new javax.swing.JLabel();
        jLabelPriceProduct8 = new javax.swing.JLabel();
        jLabelAdd8 = new javax.swing.JLabel();
        jPanelProduct7 = new javax.swing.JPanel();
        jLabelOver7 = new javax.swing.JLabel();
        jLabelImageProduct7 = new javax.swing.JLabel();
        jLabelNameProduct7 = new javax.swing.JLabel();
        jLabelPriceProduct7 = new javax.swing.JLabel();
        jLabelAdd7 = new javax.swing.JLabel();
        jPanelProduct6 = new javax.swing.JPanel();
        jLabelOver6 = new javax.swing.JLabel();
        jLabelImageProduct6 = new javax.swing.JLabel();
        jLabelNameProduct6 = new javax.swing.JLabel();
        jLabelPriceProduct6 = new javax.swing.JLabel();
        jLabelAdd6 = new javax.swing.JLabel();
        jPanelProduct5 = new javax.swing.JPanel();
        jLabelOver5 = new javax.swing.JLabel();
        jLabelImageProduct5 = new javax.swing.JLabel();
        jLabelNameProduct5 = new javax.swing.JLabel();
        jLabelPriceProduct5 = new javax.swing.JLabel();
        jLabelAdd5 = new javax.swing.JLabel();
        jPanelProduct4 = new javax.swing.JPanel();
        jLabelOver4 = new javax.swing.JLabel();
        jLabelImageProduct4 = new javax.swing.JLabel();
        jLabelNameProduct4 = new javax.swing.JLabel();
        jLabelPriceProduct4 = new javax.swing.JLabel();
        jLabelAdd4 = new javax.swing.JLabel();
        jPanelProduct3 = new javax.swing.JPanel();
        jLabelOver3 = new javax.swing.JLabel();
        jLabelImageProduct3 = new javax.swing.JLabel();
        jLabelNameProduct3 = new javax.swing.JLabel();
        jLabelPriceProduct3 = new javax.swing.JLabel();
        jLabelAdd3 = new javax.swing.JLabel();
        jPanelProduct2 = new javax.swing.JPanel();
        jLabelOver2 = new javax.swing.JLabel();
        jLabelImageProduct2 = new javax.swing.JLabel();
        jLabelNameProduct2 = new javax.swing.JLabel();
        jLabelPriceProduct2 = new javax.swing.JLabel();
        jLabelAdd2 = new javax.swing.JLabel();
        jPanelProduct1 = new javax.swing.JPanel();
        jLabelOver1 = new javax.swing.JLabel();
        jLabelImageProduct1 = new javax.swing.JLabel();
        jLabelNameProduct1 = new javax.swing.JLabel();
        jLabelPriceProduct1 = new javax.swing.JLabel();
        jLabelAdd1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(1330, 870));

        jDashboardQLBH.setBackground(new java.awt.Color(215, 220, 222));
        jDashboardQLBH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSelectedProduct.setBackground(new java.awt.Color(215, 220, 222));
        jPanelSelectedProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelShowBill.setBackground(new java.awt.Color(255, 255, 255));
        jPanelShowBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelRowBill8.setBackground(new java.awt.Color(215, 220, 222));
        jPanelRowBill8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill8.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder8.setText("8");
        jPanelRowBill8.add(jLabelNumOrder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill8.add(jLabelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName8.setText("Tên sản phẩm");
        jPanelRowBill8.add(jLabelName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill8.add(jLabelTotalPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete8.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete8MouseExited(evt);
            }
        });
        jPanelRowBill8.add(jLabelDelete8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice8.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldPrice8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice8.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldPrice8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrice8ActionPerformed(evt);
            }
        });
        jPanelRowBill8.add(jTextFieldPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount8.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldAmount8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount8.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount8.setBorder(null);
        jTextFieldAmount8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount8KeyPressed(evt);
            }
        });
        jPanelRowBill8.add(jTextFieldAmount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount8.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldDiscount8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount8.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount8.setBorder(null);
        jTextFieldDiscount8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount8KeyPressed(evt);
            }
        });
        jPanelRowBill8.add(jTextFieldDiscount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("%");
        jPanelRowBill8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount8MouseExited(evt);
            }
        });
        jPanelRowBill8.add(jLabelAddAmount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount8MouseExited(evt);
            }
        });
        jPanelRowBill8.add(jLabelMinusAmount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 830, 60));

        jPanelRowBill7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRowBill7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill7.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder7.setText("7");
        jPanelRowBill7.add(jLabelNumOrder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill7.add(jLabelImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName7.setText("Tên sản phẩm");
        jPanelRowBill7.add(jLabelName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill7.add(jLabelTotalPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete7.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete7MouseExited(evt);
            }
        });
        jPanelRowBill7.add(jLabelDelete7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice7.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPrice7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice7.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldPrice7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrice7ActionPerformed(evt);
            }
        });
        jPanelRowBill7.add(jTextFieldPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount7.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAmount7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount7.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount7.setBorder(null);
        jTextFieldAmount7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount7KeyPressed(evt);
            }
        });
        jPanelRowBill7.add(jTextFieldAmount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount7.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDiscount7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount7.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount7.setBorder(null);
        jTextFieldDiscount7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount7KeyPressed(evt);
            }
        });
        jPanelRowBill7.add(jTextFieldDiscount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("%");
        jPanelRowBill7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount7MouseExited(evt);
            }
        });
        jPanelRowBill7.add(jLabelAddAmount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount7MouseExited(evt);
            }
        });
        jPanelRowBill7.add(jLabelMinusAmount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 830, 60));

        jPanelRowBill6.setBackground(new java.awt.Color(215, 220, 222));
        jPanelRowBill6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill6.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder6.setText("6");
        jPanelRowBill6.add(jLabelNumOrder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill6.add(jLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName6.setText("Tên sản phẩm");
        jPanelRowBill6.add(jLabelName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill6.add(jLabelTotalPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete6.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete6MouseExited(evt);
            }
        });
        jPanelRowBill6.add(jLabelDelete6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice6.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldPrice6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice6.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill6.add(jTextFieldPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount6.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldAmount6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount6.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount6.setBorder(null);
        jTextFieldAmount6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount6KeyPressed(evt);
            }
        });
        jPanelRowBill6.add(jTextFieldAmount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount6.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldDiscount6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount6.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount6.setBorder(null);
        jTextFieldDiscount6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount6KeyPressed(evt);
            }
        });
        jPanelRowBill6.add(jTextFieldDiscount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("%");
        jPanelRowBill6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount6MouseExited(evt);
            }
        });
        jPanelRowBill6.add(jLabelAddAmount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount6MouseExited(evt);
            }
        });
        jPanelRowBill6.add(jLabelMinusAmount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 830, 60));

        jPanelRowBill5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRowBill5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill5.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder5.setText(" 5");
        jPanelRowBill5.add(jLabelNumOrder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill5.add(jLabelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName5.setText("Tên sản phẩm");
        jPanelRowBill5.add(jLabelName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill5.add(jLabelTotalPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete5.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete5MouseExited(evt);
            }
        });
        jPanelRowBill5.add(jLabelDelete5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice5.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPrice5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice5.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill5.add(jTextFieldPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount5.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAmount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount5.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount5.setBorder(null);
        jTextFieldAmount5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount5KeyPressed(evt);
            }
        });
        jPanelRowBill5.add(jTextFieldAmount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount5.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDiscount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount5.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount5.setBorder(null);
        jTextFieldDiscount5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount5KeyPressed(evt);
            }
        });
        jPanelRowBill5.add(jTextFieldDiscount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("%");
        jPanelRowBill5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount5MouseExited(evt);
            }
        });
        jPanelRowBill5.add(jLabelAddAmount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount5MouseExited(evt);
            }
        });
        jPanelRowBill5.add(jLabelMinusAmount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 830, 60));

        jPanelRowBill4.setBackground(new java.awt.Color(215, 220, 222));
        jPanelRowBill4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill4.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder4.setText("4");
        jPanelRowBill4.add(jLabelNumOrder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill4.add(jLabelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName4.setText("Tên sản phẩm");
        jPanelRowBill4.add(jLabelName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill4.add(jLabelTotalPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete4.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete4MouseExited(evt);
            }
        });
        jPanelRowBill4.add(jLabelDelete4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice4.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldPrice4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice4.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill4.add(jTextFieldPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount4.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldAmount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount4.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount4.setBorder(null);
        jTextFieldAmount4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount4KeyPressed(evt);
            }
        });
        jPanelRowBill4.add(jTextFieldAmount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount4.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldDiscount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount4.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount4.setBorder(null);
        jTextFieldDiscount4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount4KeyPressed(evt);
            }
        });
        jPanelRowBill4.add(jTextFieldDiscount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("%");
        jPanelRowBill4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount4MouseExited(evt);
            }
        });
        jPanelRowBill4.add(jLabelAddAmount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount4MouseExited(evt);
            }
        });
        jPanelRowBill4.add(jLabelMinusAmount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 830, 60));

        jPanelRowBill3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRowBill3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill3.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder3.setText("3");
        jPanelRowBill3.add(jLabelNumOrder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill3.add(jLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName3.setText("Tên sản phẩm");
        jPanelRowBill3.add(jLabelName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill3.add(jLabelTotalPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete3.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete3MouseExited(evt);
            }
        });
        jPanelRowBill3.add(jLabelDelete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice3.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPrice3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice3.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill3.add(jTextFieldPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount3.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAmount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount3.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount3.setBorder(null);
        jTextFieldAmount3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount3KeyPressed(evt);
            }
        });
        jPanelRowBill3.add(jTextFieldAmount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount3.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDiscount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount3.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount3.setBorder(null);
        jTextFieldDiscount3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount3KeyPressed(evt);
            }
        });
        jPanelRowBill3.add(jTextFieldDiscount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("%");
        jPanelRowBill3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount3MouseExited(evt);
            }
        });
        jPanelRowBill3.add(jLabelAddAmount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount3MouseExited(evt);
            }
        });
        jPanelRowBill3.add(jLabelMinusAmount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 830, 60));

        jPanelRowBill2.setBackground(new java.awt.Color(215, 220, 222));
        jPanelRowBill2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill2.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder2.setText("2");
        jPanelRowBill2.add(jLabelNumOrder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill2.add(jLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName2.setText("Tên sản phẩm");
        jPanelRowBill2.add(jLabelName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill2.add(jLabelTotalPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete2MouseExited(evt);
            }
        });
        jPanelRowBill2.add(jLabelDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldPrice2.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldPrice2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice2.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill2.add(jTextFieldPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jTextFieldAmount2.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldAmount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount2.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount2.setBorder(null);
        jTextFieldAmount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount2KeyPressed(evt);
            }
        });
        jPanelRowBill2.add(jTextFieldAmount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldDiscount2.setBackground(new java.awt.Color(215, 220, 222));
        jTextFieldDiscount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount2.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount2.setBorder(null);
        jTextFieldDiscount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount2KeyPressed(evt);
            }
        });
        jPanelRowBill2.add(jTextFieldDiscount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("%");
        jPanelRowBill2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelAddAmount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount2MouseExited(evt);
            }
        });
        jPanelRowBill2.add(jLabelAddAmount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabelMinusAmount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount2MouseExited(evt);
            }
        });
        jPanelRowBill2.add(jLabelMinusAmount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jPanelShowBill.add(jPanelRowBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 830, 60));

        jPanelRowBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRowBill1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelRowBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumOrder1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder1.setText("1");
        jPanelRowBill1.add(jLabelNumOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 60));

        jLabelImage1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelImage1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill1.add(jLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 60));

        jLabelName1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelName1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName1.setText("Tên sản phẩm");
        jPanelRowBill1.add(jLabelName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 60));

        jLabelTotalPrice1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPrice1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill1.add(jLabelTotalPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 60));

        jLabelDelete1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDelete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelete1MouseExited(evt);
            }
        });
        jPanelRowBill1.add(jLabelDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 60));

        jTextFieldDiscount1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDiscount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldDiscount1.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDiscount1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDiscount1.setBorder(null);
        jTextFieldDiscount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDiscount1KeyReleased(evt);
            }
        });
        jPanelRowBill1.add(jTextFieldDiscount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 1, 70, 58));

        jTextFieldAmount1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAmount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldAmount1.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldAmount1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAmount1.setText("SL");
        jTextFieldAmount1.setBorder(null);
        jTextFieldAmount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAmount1KeyPressed(evt);
            }
        });
        jPanelRowBill1.add(jTextFieldAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 1, 68, 58));

        jTextFieldPrice1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPrice1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrice1.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPrice1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPrice1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRowBill1.add(jTextFieldPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("%");
        jPanelRowBill1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 60));

        jLabelMinusAmount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinusAmount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_reduce_25px.png"))); // NOI18N
        jLabelMinusAmount1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinusAmount1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinusAmount1MouseExited(evt);
            }
        });
        jPanelRowBill1.add(jLabelMinusAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jLabelAddAmount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAddAmount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_25px_1.png"))); // NOI18N
        jLabelAddAmount1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddAmount1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddAmount1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddAmount1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddAmount1MouseExited(evt);
            }
        });
        jPanelRowBill1.add(jLabelAddAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jPanelShowBill.add(jPanelRowBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 830, 60));

        jPanelHeader.setBackground(new java.awt.Color(102, 178, 255));
        jPanelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNumOrder.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNumOrder.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumOrder.setText("Stt");
        jPanelHeader.add(jLabelNumOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        jLabelImage.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelImage.setForeground(new java.awt.Color(0, 0, 0));
        jLabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImage.setText("Ảnh");
        jLabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 30));

        jLabelName.setBackground(new java.awt.Color(255, 255, 255));
        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText("Tên sản phẩm");
        jPanelHeader.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 210, 30));

        jLabelDiscount.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDiscount.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiscount.setText("Chiết khấu");
        jPanelHeader.add(jLabelDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 90, 30));

        jLabelTotalPrice.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTotalPrice.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPrice.setText("Thành tiền");
        jLabelTotalPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 30));

        jLabelPrice.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPrice.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrice.setText("Đơn giá");
        jLabelPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 30));

        jLabelAmount.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAmount.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount.setText("Số lượng");
        jPanelHeader.add(jLabelAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 100, 30));

        jLabelDelete.setBackground(new java.awt.Color(204, 204, 204));
        jLabelDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDelete.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_trash_20px_1.png"))); // NOI18N
        jLabelDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeader.add(jLabelDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 30));

        jPanelShowBill.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 30));

        jPanelControlPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlPageBill2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageBill2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageBill2.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageBill2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageBill2.setText("1");
        jTextFieldPageBill2.setBorder(null);
        jTextFieldPageBill2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageBill2KeyReleased(evt);
            }
        });
        jPanelControlPageBill2.add(jTextFieldPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, -1));

        jLabelPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageBill2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageBill2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageBill2.setText("/1");
        jPanelControlPageBill2.add(jLabelPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 36, -1));

        jLabelRightPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRightPageBill2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRightPageBill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightPageBill2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightPageBill2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightPageBill2MouseExited(evt);
            }
        });
        jPanelControlPageBill2.add(jLabelRightPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabelLeftPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeftPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeftPageBill2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeftPageBill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBill2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBill2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBill2MouseExited(evt);
            }
        });
        jPanelControlPageBill2.add(jLabelLeftPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabelSkipToEndPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEndPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEndPageBill2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEndPageBill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBill2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBill2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBill2MouseExited(evt);
            }
        });
        jPanelControlPageBill2.add(jLabelSkipToEndPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        jLabelSkipToStartPageBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStartPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStartPageBill2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStartPageBill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBill2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBill2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBill2MouseExited(evt);
            }
        });
        jPanelControlPageBill2.add(jLabelSkipToStartPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanelShowBill.add(jPanelControlPageBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 210, 20));

        jPanelSelectedProduct.add(jPanelShowBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 540));

        jDashboardQLBH.add(jPanelSelectedProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 830, 540));

        jPanelPay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelStaff2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStaff2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStaff2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStaff2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_pencil_15px.png"))); // NOI18N
        jLabelStaff2.setText("Ghi chú:");
        jPanelPay.add(jLabelStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 100, -1));

        jLabelStaff1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStaff1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStaff1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStaff1.setText("Khách hàng:");
        jPanelPay.add(jLabelStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, -1));

        jLabelStaff.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStaff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelStaff.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStaff.setText("Nhân viên bán hàng:");
        jPanelPay.add(jLabelStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelPay.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 10, 300));

        jTextFieldCustomerPay.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCustomerPay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCustomerPay.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCustomerPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCustomerPay.setText("0");
        jTextFieldCustomerPay.setBorder(null);
        jPanelPay.add(jTextFieldCustomerPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 110, -1));

        jLabelTotalPriceBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalPriceBill.setText("0");
        jPanelPay.add(jLabelTotalPriceBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 120, -1));

        jLabelDiscountBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill1.setText("Giảm giá thêm:");
        jPanelPay.add(jLabelDiscountBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 100, -1));

        jLabelDiscountBill.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDiscountBill.setText("0");
        jPanelPay.add(jLabelDiscountBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 120, -1));

        jLabelCustomerNeedPay.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNeedPay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCustomerNeedPay.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCustomerNeedPay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCustomerNeedPay.setText("0");
        jPanelPay.add(jLabelCustomerNeedPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 110, 20));

        jLabelCustomerPay.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerPay.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerPay.setText("Khách thanh toán:");
        jPanelPay.add(jLabelCustomerPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 120, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanelPay.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 10, 300));

        jLabelExcessCash.setBackground(new java.awt.Color(255, 255, 255));
        jLabelExcessCash.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelExcessCash.setForeground(new java.awt.Color(51, 255, 51));
        jLabelExcessCash.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelExcessCash.setText("0");
        jPanelPay.add(jLabelExcessCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 110, -1));

        jTextFieldNote.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNote.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNote.setBorder(null);
        jPanelPay.add(jTextFieldNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 260, 30));

        jButtonSave.setBackground(new java.awt.Color(102, 178, 255));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSave.setText("Lưu");
        jButtonSave.setFocusable(false);
        jButtonSave.setOpaque(true);
        jButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseExited(evt);
            }
        });
        jPanelPay.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 140, 60));

        jLabelTotalPriceBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPriceBill1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPriceBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPriceBill1.setText("Tổng tiền hàng:");
        jPanelPay.add(jLabelTotalPriceBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 100, -1));

        jLabelDiscountBill2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiscountBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDiscountBill2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiscountBill2.setText("Chiết khấu:");
        jPanelPay.add(jLabelDiscountBill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 100, -1));

        jTextFieldMoreDiscount.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldMoreDiscount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldMoreDiscount.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldMoreDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldMoreDiscount.setText("0");
        jTextFieldMoreDiscount.setBorder(null);
        jPanelPay.add(jTextFieldMoreDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 110, -1));

        jLabelCustomerNeedPay1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCustomerNeedPay1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerNeedPay1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCustomerNeedPay1.setText("Khách cần trả:");
        jPanelPay.add(jLabelCustomerNeedPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 100, -1));

        jLabelExcessCash1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelExcessCash1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelExcessCash1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelExcessCash1.setText("Tiền thừa:");
        jPanelPay.add(jLabelExcessCash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 100, -1));
        jPanelPay.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 110, 10));
        jPanelPay.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 260, 10));
        jPanelPay.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 110, 10));

        jDashboardQLBH.add(jPanelPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 830, 320));

        jPanelSelectProduct.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSelectProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelControlPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelControlPageBill1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPageBill1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPageBill1.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPageBill1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPageBill1.setText("1");
        jTextFieldPageBill1.setBorder(null);
        jTextFieldPageBill1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPageBill1KeyReleased(evt);
            }
        });
        jPanelControlPageBill1.add(jTextFieldPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, -1));

        jLabelPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPageBill1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPageBill1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPageBill1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPageBill1.setText("/1");
        jPanelControlPageBill1.add(jLabelPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 36, -1));

        jLabelRightPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRightPageBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png"))); // NOI18N
        jLabelRightPageBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRightPageBill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRightPageBill1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRightPageBill1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRightPageBill1MouseExited(evt);
            }
        });
        jPanelControlPageBill1.add(jLabelRightPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabelLeftPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLeftPageBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeftPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png"))); // NOI18N
        jLabelLeftPageBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLeftPageBill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBill1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBill1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeftPageBill1MouseExited(evt);
            }
        });
        jPanelControlPageBill1.add(jLabelLeftPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabelSkipToEndPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToEndPageBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToEndPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png"))); // NOI18N
        jLabelSkipToEndPageBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToEndPageBill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBill1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBill1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToEndPageBill1MouseExited(evt);
            }
        });
        jPanelControlPageBill1.add(jLabelSkipToEndPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        jLabelSkipToStartPageBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSkipToStartPageBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSkipToStartPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png"))); // NOI18N
        jLabelSkipToStartPageBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSkipToStartPageBill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBill1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBill1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSkipToStartPageBill1MouseExited(evt);
            }
        });
        jPanelControlPageBill1.add(jLabelSkipToStartPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanelSelectProduct.add(jPanelControlPageBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 210, 20));

        jLabelSearchBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSearchBill1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSearchBill1.setForeground(new java.awt.Color(120, 120, 120));
        jLabelSearchBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        jLabelSearchBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelSelectProduct.add(jLabelSearchBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jTextFieldSearchBill1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSearchBill1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldSearchBill1.setForeground(new java.awt.Color(120, 120, 120));
        jTextFieldSearchBill1.setText("Tìm kiếm");
        jTextFieldSearchBill1.setBorder(null);
        jTextFieldSearchBill1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchBill1.setOpaque(false);
        jTextFieldSearchBill1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchBill1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchBill1FocusLost(evt);
            }
        });
        jTextFieldSearchBill1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchBill1KeyReleased(evt);
            }
        });
        jPanelSelectProduct.add(jTextFieldSearchBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 240, 30));

        jLabelFrameSearchBill1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFrameSearchBill1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelSelectProduct.add(jLabelFrameSearchBill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 30));

        jPanelProduct12.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver12.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver12.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver12.setText(" Hết hàng");
        jLabelOver12.setOpaque(true);
        jPanelProduct12.add(jLabelOver12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct12.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct12MouseExited(evt);
            }
        });
        jPanelProduct12.add(jLabelImageProduct12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct12.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct12.setText("Tên sản phẩm");
        jLabelNameProduct12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct12MouseExited(evt);
            }
        });
        jPanelProduct12.add(jLabelNameProduct12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct12.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct12.setText("Giá");
        jPanelProduct12.add(jLabelPriceProduct12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd12.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd12MouseExited(evt);
            }
        });
        jPanelProduct12.add(jLabelAdd12, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 665, -1, -1));

        jPanelProduct11.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver11.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver11.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver11.setText(" Hết hàng");
        jLabelOver11.setOpaque(true);
        jPanelProduct11.add(jLabelOver11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct11.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct11MouseExited(evt);
            }
        });
        jPanelProduct11.add(jLabelImageProduct11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct11.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct11.setText("Tên sản phẩm");
        jLabelNameProduct11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct11MouseExited(evt);
            }
        });
        jPanelProduct11.add(jLabelNameProduct11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct11.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct11.setText("Giá");
        jPanelProduct11.add(jLabelPriceProduct11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd11.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd11MouseExited(evt);
            }
        });
        jPanelProduct11.add(jLabelAdd11, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 665, -1, -1));

        jPanelProduct10.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver10.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver10.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver10.setText(" Hết hàng");
        jLabelOver10.setOpaque(true);
        jPanelProduct10.add(jLabelOver10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct10.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct10MouseExited(evt);
            }
        });
        jPanelProduct10.add(jLabelImageProduct10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct10.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct10.setText("Tên sản phẩm");
        jLabelNameProduct10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct10MouseExited(evt);
            }
        });
        jPanelProduct10.add(jLabelNameProduct10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct10.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct10.setText("Giá");
        jPanelProduct10.add(jLabelPriceProduct10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd10.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd10MouseExited(evt);
            }
        });
        jPanelProduct10.add(jLabelAdd10, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 665, -1, -1));

        jPanelProduct9.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver9.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver9.setText(" Hết hàng");
        jLabelOver9.setOpaque(true);
        jPanelProduct9.add(jLabelOver9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct9.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct9MouseExited(evt);
            }
        });
        jPanelProduct9.add(jLabelImageProduct9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct9.setText("Tên sản phẩm");
        jLabelNameProduct9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct9MouseExited(evt);
            }
        });
        jPanelProduct9.add(jLabelNameProduct9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct9.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct9.setText("Giá");
        jPanelProduct9.add(jLabelPriceProduct9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd9.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd9MouseExited(evt);
            }
        });
        jPanelProduct9.add(jLabelAdd9, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, -1, -1));

        jPanelProduct8.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver8.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver8.setText(" Hết hàng");
        jLabelOver8.setOpaque(true);
        jPanelProduct8.add(jLabelOver8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct8.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct8MouseExited(evt);
            }
        });
        jPanelProduct8.add(jLabelImageProduct8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct8.setText("Tên sản phẩm");
        jLabelNameProduct8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct8MouseExited(evt);
            }
        });
        jPanelProduct8.add(jLabelNameProduct8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct8.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct8.setText("Giá");
        jPanelProduct8.add(jLabelPriceProduct8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd8.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd8MouseExited(evt);
            }
        });
        jPanelProduct8.add(jLabelAdd8, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        jPanelProduct7.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver7.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver7.setText(" Hết hàng");
        jLabelOver7.setOpaque(true);
        jPanelProduct7.add(jLabelOver7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct7MouseExited(evt);
            }
        });
        jPanelProduct7.add(jLabelImageProduct7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct7.setText("Tên sản phẩm");
        jLabelNameProduct7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct7MouseExited(evt);
            }
        });
        jPanelProduct7.add(jLabelNameProduct7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct7.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct7.setText("Giá");
        jPanelProduct7.add(jLabelPriceProduct7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd7.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd7MouseExited(evt);
            }
        });
        jPanelProduct7.add(jLabelAdd7, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jPanelProduct6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver6.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver6.setText(" Hết hàng");
        jLabelOver6.setOpaque(true);
        jPanelProduct6.add(jLabelOver6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct6MouseExited(evt);
            }
        });
        jPanelProduct6.add(jLabelImageProduct6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct6.setText("Tên sản phẩm");
        jLabelNameProduct6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct6MouseExited(evt);
            }
        });
        jPanelProduct6.add(jLabelNameProduct6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct6.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct6.setText("Giá");
        jPanelProduct6.add(jLabelPriceProduct6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd6.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd6MouseExited(evt);
            }
        });
        jPanelProduct6.add(jLabelAdd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 255, -1, -1));

        jPanelProduct5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver5.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver5.setText(" Hết hàng");
        jLabelOver5.setOpaque(true);
        jPanelProduct5.add(jLabelOver5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct5MouseExited(evt);
            }
        });
        jPanelProduct5.add(jLabelImageProduct5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct5.setText("Tên sản phẩm");
        jLabelNameProduct5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct5MouseExited(evt);
            }
        });
        jPanelProduct5.add(jLabelNameProduct5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct5.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct5.setText("Giá");
        jPanelProduct5.add(jLabelPriceProduct5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd5.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd5MouseExited(evt);
            }
        });
        jPanelProduct5.add(jLabelAdd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 255, -1, -1));

        jPanelProduct4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver4.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver4.setText(" Hết hàng");
        jLabelOver4.setOpaque(true);
        jPanelProduct4.add(jLabelOver4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct4MouseExited(evt);
            }
        });
        jPanelProduct4.add(jLabelImageProduct4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct4.setText("Tên sản phẩm");
        jLabelNameProduct4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct4MouseExited(evt);
            }
        });
        jPanelProduct4.add(jLabelNameProduct4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct4.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct4.setText("Giá");
        jPanelProduct4.add(jLabelPriceProduct4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd4MouseExited(evt);
            }
        });
        jPanelProduct4.add(jLabelAdd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 255, -1, -1));

        jPanelProduct3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver3.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver3.setText(" Hết hàng");
        jLabelOver3.setOpaque(true);
        jPanelProduct3.add(jLabelOver3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct3MouseExited(evt);
            }
        });
        jPanelProduct3.add(jLabelImageProduct3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct3.setText("Bàn phím");
        jLabelNameProduct3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct3MouseExited(evt);
            }
        });
        jPanelProduct3.add(jLabelNameProduct3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct3.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct3.setText("Giá");
        jPanelProduct3.add(jLabelPriceProduct3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd3MouseExited(evt);
            }
        });
        jPanelProduct3.add(jLabelAdd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jPanelProduct2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver2.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver2.setText(" Hết hàng");
        jLabelOver2.setOpaque(true);
        jPanelProduct2.add(jLabelOver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct2MouseExited(evt);
            }
        });
        jPanelProduct2.add(jLabelImageProduct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct2.setText("Chuột");
        jLabelNameProduct2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct2MouseExited(evt);
            }
        });
        jPanelProduct2.add(jLabelNameProduct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct2.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct2.setText("Giá");
        jPanelProduct2.add(jLabelPriceProduct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd2MouseExited(evt);
            }
        });
        jPanelProduct2.add(jLabelAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jPanelProduct1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelProduct1.setPreferredSize(new java.awt.Dimension(150, 200));
        jPanelProduct1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOver1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelOver1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOver1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOver1.setText(" Hết hàng");
        jLabelOver1.setOpaque(true);
        jPanelProduct1.add(jLabelOver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 70, 30));

        jLabelImageProduct1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImageProduct1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImageProduct1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelImageProduct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelImageProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelImageProduct1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImageProduct1MouseExited(evt);
            }
        });
        jPanelProduct1.add(jLabelImageProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 135));

        jLabelNameProduct1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNameProduct1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameProduct1.setText("Tên sản phẩm");
        jLabelNameProduct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNameProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNameProduct1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNameProduct1MouseExited(evt);
            }
        });
        jPanelProduct1.add(jLabelNameProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 135, 140, 45));

        jLabelPriceProduct1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPriceProduct1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPriceProduct1.setText("Giá");
        jPanelProduct1.add(jLabelPriceProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 120, 20));

        jLabelAdd1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbhgg/Icon/icons8_add_new_20px_1.png"))); // NOI18N
        jLabelAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdd1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAdd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAdd1MouseExited(evt);
            }
        });
        jPanelProduct1.add(jLabelAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 180, 20, 20));

        jPanelSelectProduct.add(jPanelProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jDashboardQLBH.add(jPanelSelectProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 870));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDashboardQLBH, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDashboardQLBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPageBill1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageBill1KeyReleased
        try {
            showProductsSale(ListGoodsSale, countProductSale);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPageBill1KeyReleased

    private void jLabelRightPageBill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBill1MouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill1.getText());
        int jlabelrightb = countProductSale / 12 + setPageProductSale;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill1.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill1.getText()) + 1));
            try {
                showProductsSale(ListGoodsSale, countProductSale);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelRightPageBill1MouseClicked

    private void jLabelRightPageBill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBill1MouseEntered
        jLabelRightPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightPageBill1MouseEntered

    private void jLabelRightPageBill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBill1MouseExited
        jLabelRightPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightPageBill1MouseExited

    private void jLabelLeftPageBill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBill1MouseClicked
        if (Integer.parseInt(jTextFieldPageBill1.getText()) > 1) {
            jTextFieldPageBill1.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill1.getText()) - 1));
            try {
                showProductsSale(ListGoodsSale, countProductSale);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftPageBill1MouseClicked

    private void jLabelLeftPageBill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBill1MouseEntered
        jLabelLeftPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftPageBill1MouseEntered

    private void jLabelLeftPageBill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBill1MouseExited
        jLabelLeftPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftPageBill1MouseExited

    private void jLabelSkipToEndPageBill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBill1MouseClicked
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill1.getText());
        int jlabelrightb = countProductSale / 12 + setPageProductSale;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill1.setText(String.valueOf(countProductSale / 12 + setPageProductSale));
            try {
                showProductsSale(ListGoodsSale, countProductSale);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndPageBill1MouseClicked

    private void jLabelSkipToEndPageBill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBill1MouseEntered
        jLabelSkipToEndPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBill1MouseEntered

    private void jLabelSkipToEndPageBill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBill1MouseExited
        jLabelSkipToEndPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBill1MouseExited

    private void jLabelSkipToStartPageBill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBill1MouseClicked
        if (Integer.parseInt(jTextFieldPageBill1.getText()) > 1) {
            jTextFieldPageBill1.setText("1");
            try {
                showProductsSale(ListGoodsSale, countProductSale);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartPageBill1MouseClicked

    private void jLabelSkipToStartPageBill1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBill1MouseEntered
        jLabelSkipToStartPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBill1MouseEntered

    private void jLabelSkipToStartPageBill1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBill1MouseExited
        jLabelSkipToStartPageBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBill1MouseExited

    private void jTextFieldSearchBill1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchBill1FocusGained
        jTextFieldSearchBill1.setText("");
    }//GEN-LAST:event_jTextFieldSearchBill1FocusGained

    private void jTextFieldSearchBill1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchBill1FocusLost
        if (jTextFieldSearchBill1.getText().equals("")) {
            jTextFieldSearchBill1.setText("Tìm kiếm");
        }
    }//GEN-LAST:event_jTextFieldSearchBill1FocusLost

    private void jTextFieldSearchBill1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchBill1KeyReleased
        try {
            ListGoodsSale = GoodsDao.searchProduct(jTextFieldSearchBill1.getText());
            countProductSale = GoodsDao.countSearchProduct(jTextFieldSearchBill1.getText());
            showProductsSale(ListGoodsSale, countProductSale);
            jTextFieldPageBill1.setText("1");
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSearchBill1KeyReleased

    private void jTextFieldPageBill2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPageBill2KeyReleased
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPageBill2KeyReleased

    private void jLabelRightPageBill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBill2MouseClicked
        countProductBill = ListBill1.size();
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill2.getText());
        int jlabelrightb = countProductBill / 8 + setPageBill;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill2.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill2.getText()) + 1));
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelRightPageBill2MouseClicked

    private void jLabelRightPageBill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBill2MouseEntered
        jLabelRightPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px_1.png")));
    }//GEN-LAST:event_jLabelRightPageBill2MouseEntered

    private void jLabelRightPageBill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRightPageBill2MouseExited
        jLabelRightPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_right_20px.png")));
    }//GEN-LAST:event_jLabelRightPageBill2MouseExited

    private void jLabelLeftPageBill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBill2MouseClicked
        if (Integer.parseInt(jTextFieldPageBill2.getText()) > 1) {
            jTextFieldPageBill2.setText(String.valueOf(Integer.parseInt(jTextFieldPageBill2.getText()) - 1));
            countProductBill = ListBill1.size();
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelLeftPageBill2MouseClicked

    private void jLabelLeftPageBill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBill2MouseEntered
        jLabelLeftPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px.png")));
    }//GEN-LAST:event_jLabelLeftPageBill2MouseEntered

    private void jLabelLeftPageBill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeftPageBill2MouseExited
        jLabelLeftPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_left_20px_1.png")));
    }//GEN-LAST:event_jLabelLeftPageBill2MouseExited

    private void jLabelSkipToEndPageBill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBill2MouseClicked
        countProductBill = ListBill1.size();
        int jlabelrighta = Integer.parseInt(jTextFieldPageBill2.getText());
        int jlabelrightb = countProductBill / 8 + setPageBill;
        if (jlabelrighta < jlabelrightb) {
            jTextFieldPageBill2.setText(String.valueOf(countProductBill / 8 + setPageBill));
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToEndPageBill2MouseClicked

    private void jLabelSkipToEndPageBill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBill2MouseEntered
        jLabelSkipToEndPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBill2MouseEntered

    private void jLabelSkipToEndPageBill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToEndPageBill2MouseExited
        jLabelSkipToEndPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_end_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToEndPageBill2MouseExited

    private void jLabelSkipToStartPageBill2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBill2MouseClicked
        if (Integer.parseInt(jTextFieldPageBill2.getText()) > 1) {
            jTextFieldPageBill2.setText("1");
            countProductBill = ListBill1.size();
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelSkipToStartPageBill2MouseClicked

    private void jLabelSkipToStartPageBill2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBill2MouseEntered
        jLabelSkipToStartPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBill2MouseEntered

    private void jLabelSkipToStartPageBill2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSkipToStartPageBill2MouseExited
        jLabelSkipToStartPageBill2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_skip_to_start_20px_1.png")));
    }//GEN-LAST:event_jLabelSkipToStartPageBill2MouseExited

    private void jTextFieldPrice7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrice7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrice7ActionPerformed

    private void jLabelAdd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd1MouseEntered
        jLabelAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd1MouseEntered

    private void jLabelAdd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd1MouseExited
        jLabelAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd1MouseExited

    private void jLabelAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd1MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd1MouseClicked

    private void jLabelAdd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd2MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 1);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd2MouseClicked

    private void jLabelAdd2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd2MouseEntered
        jLabelAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd2MouseEntered

    private void jLabelAdd2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd2MouseExited
        jLabelAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd2MouseExited

    private void jLabelAdd3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd3MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 2);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd3MouseClicked

    private void jLabelAdd3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd3MouseEntered
        jLabelAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd3MouseEntered

    private void jLabelAdd3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd3MouseExited
        jLabelAdd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd3MouseExited

    private void jLabelAdd4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd4MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 3);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd4MouseClicked

    private void jLabelAdd4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd4MouseEntered
        jLabelAdd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd4MouseEntered

    private void jLabelAdd4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd4MouseExited
        jLabelAdd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd4MouseExited

    private void jLabelAdd5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd5MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 4);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd5MouseClicked

    private void jLabelAdd5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd5MouseEntered
        jLabelAdd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd5MouseEntered

    private void jLabelAdd5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd5MouseExited
        jLabelAdd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd5MouseExited

    private void jLabelAdd6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd6MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 5);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd6MouseClicked

    private void jLabelAdd6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd6MouseEntered
        jLabelAdd6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd6MouseEntered

    private void jLabelAdd6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd6MouseExited
        jLabelAdd6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd6MouseExited

    private void jLabelAdd7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd7MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 6);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd7MouseClicked

    private void jLabelAdd7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd7MouseEntered
        jLabelAdd7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd7MouseEntered

    private void jLabelAdd7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd7MouseExited
        jLabelAdd7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd7MouseExited

    private void jLabelAdd8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd8MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 7);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd8MouseClicked

    private void jLabelAdd8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd8MouseEntered
        jLabelAdd8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd8MouseEntered

    private void jLabelAdd8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd8MouseExited
        jLabelAdd8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd8MouseExited

    private void jLabelAdd9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd9MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 8);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd9MouseClicked

    private void jLabelAdd9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd9MouseEntered
        jLabelAdd9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd9MouseEntered

    private void jLabelAdd9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd9MouseExited
        jLabelAdd9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd9MouseExited

    private void jLabelAdd10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd10MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 9);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd10MouseClicked

    private void jLabelAdd10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd10MouseEntered
        jLabelAdd10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd10MouseEntered

    private void jLabelAdd10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd10MouseExited
        jLabelAdd10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd10MouseExited

    private void jLabelAdd11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd11MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 10);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd11MouseClicked

    private void jLabelAdd11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd11MouseEntered
        jLabelAdd11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd11MouseEntered

    private void jLabelAdd11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd11MouseExited
        jLabelAdd11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd11MouseExited

    private void jLabelAdd12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd12MouseClicked
        setPageProductSale = (countProductSale % 12 == 0) ? 0 : 1;
        jLabelPageBill1.setText("/" + String.valueOf(countProductSale / 12 + setPageProductSale));
        int pageProductSale = (Integer.parseInt(jTextFieldPageBill1.getText()) - 1) * 12;
        Invoicedetails i = new Invoicedetails();
        Goods g = ListGoodsSale.get(pageProductSale + 11);
        if (g.getAmount() > 0) {
            boolean checkExist = false, checkAmount = false;
            for (Invoicedetails ii : ListBill1) {
                if (g.getItemcode().equals(ii.getItemcode())) {
                    if (g.getAmount() <= ii.getAmount()) {
                        checkAmount = true;
                    } else {
                        int a = ii.getAmount() + 1;
                        ii.setAmount(a);
                        checkExist = true;
                    }
                }
            }
            if (!checkExist && !checkAmount) {
                i.setCodebill("B000000019");
                i.setItemcode(g.getItemcode());
                i.setPrice(g.getPrice());
                i.setAmount(1);
                i.setDiscount(0);
                ListBill1.add(i);
            }
            try {
                showProductsBill(ListBill1, countProductBill);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelAdd12MouseClicked

    private void jLabelAdd12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd12MouseEntered
        jLabelAdd12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_2.png")));
    }//GEN-LAST:event_jLabelAdd12MouseEntered

    private void jLabelAdd12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdd12MouseExited
        jLabelAdd12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_20px_1.png")));
    }//GEN-LAST:event_jLabelAdd12MouseExited

    private void jTextFieldPrice8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrice8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrice8ActionPerformed

    private void jLabelNameProduct1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct1MouseEntered
        jLabelNameProduct1.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct1MouseEntered

    private void jLabelImageProduct1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct1MouseEntered
        jLabelNameProduct1.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct1MouseEntered

    private void jLabelNameProduct1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct1MouseExited
        jLabelNameProduct1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct1MouseExited

    private void jLabelImageProduct1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct1MouseExited
        jLabelNameProduct1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct1MouseExited

    private void jLabelImageProduct2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct2MouseEntered
        jLabelNameProduct2.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct2MouseEntered

    private void jLabelImageProduct2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct2MouseExited
        jLabelNameProduct2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct2MouseExited

    private void jLabelNameProduct2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct2MouseEntered
        jLabelNameProduct2.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct2MouseEntered

    private void jLabelNameProduct2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct2MouseExited
        jLabelNameProduct2.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct2MouseExited

    private void jLabelImageProduct3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct3MouseEntered
        jLabelNameProduct3.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct3MouseEntered

    private void jLabelImageProduct3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct3MouseExited
        jLabelNameProduct3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct3MouseExited

    private void jLabelNameProduct3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct3MouseEntered
        jLabelNameProduct3.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct3MouseEntered

    private void jLabelNameProduct3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct3MouseExited
        jLabelNameProduct3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct3MouseExited

    private void jLabelImageProduct4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct4MouseEntered
        jLabelNameProduct4.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct4MouseEntered

    private void jLabelImageProduct4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct4MouseExited
        jLabelNameProduct4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct4MouseExited

    private void jLabelNameProduct4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct4MouseEntered
        jLabelNameProduct4.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct4MouseEntered

    private void jLabelNameProduct4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct4MouseExited
        jLabelNameProduct4.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct4MouseExited

    private void jLabelImageProduct5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct5MouseEntered
        jLabelNameProduct5.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct5MouseEntered

    private void jLabelImageProduct5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct5MouseExited
        jLabelNameProduct5.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct5MouseExited

    private void jLabelNameProduct5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct5MouseEntered
        jLabelNameProduct5.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct5MouseEntered

    private void jLabelNameProduct5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct5MouseExited
        jLabelNameProduct5.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct5MouseExited

    private void jLabelImageProduct6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct6MouseEntered
        jLabelNameProduct6.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct6MouseEntered

    private void jLabelImageProduct6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct6MouseExited
        jLabelNameProduct6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct6MouseExited

    private void jLabelNameProduct6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct6MouseEntered
        jLabelNameProduct6.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct6MouseEntered

    private void jLabelNameProduct6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct6MouseExited
        jLabelNameProduct6.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct6MouseExited

    private void jLabelImageProduct7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct7MouseEntered
        jLabelNameProduct7.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct7MouseEntered

    private void jLabelImageProduct7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct7MouseExited
        jLabelNameProduct7.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct7MouseExited

    private void jLabelNameProduct7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct7MouseEntered
        jLabelNameProduct7.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct7MouseEntered

    private void jLabelNameProduct7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct7MouseExited
        jLabelNameProduct7.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct7MouseExited

    private void jLabelImageProduct8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct8MouseEntered
        jLabelNameProduct8.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct8MouseEntered

    private void jLabelImageProduct8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct8MouseExited
        jLabelNameProduct8.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct8MouseExited

    private void jLabelNameProduct8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct8MouseEntered
        jLabelNameProduct8.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct8MouseEntered

    private void jLabelNameProduct8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct8MouseExited
        jLabelNameProduct8.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct8MouseExited

    private void jLabelImageProduct9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct9MouseEntered
        jLabelNameProduct9.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct9MouseEntered

    private void jLabelImageProduct9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct9MouseExited
        jLabelNameProduct9.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct9MouseExited

    private void jLabelNameProduct9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct9MouseEntered
        jLabelNameProduct9.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct9MouseEntered

    private void jLabelNameProduct9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct9MouseExited
        jLabelNameProduct9.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct9MouseExited

    private void jLabelImageProduct10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct10MouseEntered
        jLabelNameProduct10.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct10MouseEntered

    private void jLabelImageProduct10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct10MouseExited
        jLabelNameProduct10.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct10MouseExited

    private void jLabelNameProduct10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct10MouseEntered
        jLabelNameProduct10.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct10MouseEntered

    private void jLabelNameProduct10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct10MouseExited
        jLabelNameProduct10.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct10MouseExited

    private void jLabelImageProduct11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct11MouseEntered
        jLabelNameProduct11.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct11MouseEntered

    private void jLabelImageProduct11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct11MouseExited
        jLabelNameProduct11.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct11MouseExited

    private void jLabelNameProduct11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct11MouseEntered
        jLabelNameProduct11.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct11MouseEntered

    private void jLabelNameProduct11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct11MouseExited
        jLabelNameProduct11.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct11MouseExited

    private void jLabelImageProduct12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct12MouseEntered
        jLabelNameProduct12.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelImageProduct12MouseEntered

    private void jLabelImageProduct12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageProduct12MouseExited
        jLabelNameProduct12.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelImageProduct12MouseExited

    private void jLabelNameProduct12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct12MouseEntered
        jLabelNameProduct12.setForeground(new java.awt.Color(102, 178, 255));
    }//GEN-LAST:event_jLabelNameProduct12MouseEntered

    private void jLabelNameProduct12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameProduct12MouseExited
        jLabelNameProduct12.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLabelNameProduct12MouseExited

    private void jLabelDelete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete1MouseEntered
        jLabelDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete1MouseEntered

    private void jLabelDelete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete1MouseExited
        jLabelDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete1MouseExited

    private void jLabelDelete2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete2MouseEntered
        jLabelDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete2MouseEntered

    private void jLabelDelete2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete2MouseExited
        jLabelDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete2MouseExited

    private void jLabelDelete3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete3MouseEntered
        jLabelDelete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete3MouseEntered

    private void jLabelDelete3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete3MouseExited
        jLabelDelete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete3MouseExited

    private void jLabelDelete4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete4MouseEntered
        jLabelDelete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete4MouseEntered

    private void jLabelDelete4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete4MouseExited
        jLabelDelete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete4MouseExited

    private void jLabelDelete5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete5MouseEntered
        jLabelDelete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete5MouseEntered

    private void jLabelDelete5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete5MouseExited
        jLabelDelete5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete5MouseExited

    private void jLabelDelete6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete6MouseEntered
        jLabelDelete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete6MouseEntered

    private void jLabelDelete6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete6MouseExited
        jLabelDelete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete6MouseExited

    private void jLabelDelete7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete7MouseEntered
        jLabelDelete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete7MouseEntered

    private void jLabelDelete7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete7MouseExited
        jLabelDelete7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete7MouseExited

    private void jLabelDelete8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete8MouseEntered
        jLabelDelete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px.png")));
    }//GEN-LAST:event_jLabelDelete8MouseEntered

    private void jLabelDelete8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete8MouseExited
        jLabelDelete8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_trash_20px_1.png")));
    }//GEN-LAST:event_jLabelDelete8MouseExited

    private void jLabelDelete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete1MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete1MouseClicked

    private void jLabelDelete2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete2MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 1);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete2MouseClicked

    private void jLabelDelete3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete3MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 2);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete3MouseClicked

    private void jLabelDelete4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete4MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 3);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete4MouseClicked

    private void jLabelDelete5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete5MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 4);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete5MouseClicked

    private void jLabelDelete6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete6MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 5);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete6MouseClicked

    private void jLabelDelete7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete7MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 6);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete7MouseClicked

    private void jLabelDelete8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete8MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        ListBill1.remove(pageBill + 7);
        try {
            showProductsBill(ListBill1, countProductBill);
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelDelete8MouseClicked

    private void jButtonSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveMouseEntered
//        jButtonSave.setForeground(new java.awt.Color(215,220,222));
    }//GEN-LAST:event_jButtonSaveMouseEntered

    private void jButtonSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveMouseExited
//        jButtonSave.setForeground(new java.awt.Color(102,178,255));
    }//GEN-LAST:event_jButtonSaveMouseExited

    private void jTextFieldDiscount1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount1KeyReleased

    }//GEN-LAST:event_jTextFieldDiscount1KeyReleased

    private void jTextFieldDiscount1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount1.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount1KeyPressed

    private void jTextFieldDiscount2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount2.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 1).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount2KeyPressed

    private void jTextFieldDiscount3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount3.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 2).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount3KeyPressed

    private void jTextFieldDiscount4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount4.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 3).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount4KeyPressed

    private void jTextFieldDiscount5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount5.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 4).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount5KeyPressed

    private void jTextFieldDiscount6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount6KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount6.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 5).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount6KeyPressed

    private void jTextFieldDiscount7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount7KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount7.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 6).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount7KeyPressed

    private void jTextFieldDiscount8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscount8KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int dc = Integer.parseInt(jTextFieldDiscount8.getText());
            if (dc > 0 && dc < 100) {
                countProductBill = ListBill1.size();
                setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
                jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
                int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
                ListBill1.get(pageBill + 7).setDiscount(dc);
                try {
                    showProductsBill(ListBill1, countProductBill);
                } catch (SQLException ex) {
                    Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldDiscount8KeyPressed

    private void jTextFieldAmount1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount1.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jTextFieldAmount1KeyPressed

    private void jLabelAddAmount1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount1MouseEntered
        jLabelAddAmount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount1MouseEntered

    private void jLabelAddAmount1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount1MouseExited
        jLabelAddAmount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount1MouseExited

    private void jLabelMinusAmount1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount1MouseEntered
        jLabelMinusAmount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount1MouseEntered

    private void jLabelMinusAmount1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount1MouseExited
        jLabelMinusAmount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount1MouseExited

    private void jLabelAddAmount1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount1MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount1MouseClicked

    private void jLabelMinusAmount1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount1MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount1MouseClicked

    private void jTextFieldAmount2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount2.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 1).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 1);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 1).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 1).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount2KeyPressed

    private void jTextFieldAmount3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount3.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 2).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 2);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 2).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 2).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount3KeyPressed

    private void jTextFieldAmount4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount4KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount4.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 3).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 3);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 3).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 3).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount4KeyPressed

    private void jTextFieldAmount5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount5KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount5.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 4).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 4);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 4).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 4).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount5KeyPressed

    private void jTextFieldAmount6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount6KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount6.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 5).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 5);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 5).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 5).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount6KeyPressed

    private void jTextFieldAmount7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount7KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount7.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 6).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 6);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 6).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 6).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount7KeyPressed

    private void jTextFieldAmount8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmount8KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int am = Integer.parseInt(jTextFieldAmount8.getText());
            countProductBill = ListBill1.size();
            setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
            jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
            int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
            try {
                Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 7).getItemcode());
                if (am <= 0) {
                    ListBill1.remove(pageBill + 7);
                    showProductsBill(ListBill1, countProductBill);
                } else if (am > g.getAmount()) {
                    ListBill1.get(pageBill + 7).setAmount(g.getAmount());
                    showProductsBill(ListBill1, countProductBill);
                } else {
                    ListBill1.get(pageBill + 7).setAmount(am);
                    showProductsBill(ListBill1, countProductBill);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextFieldAmount8KeyPressed

    private void jLabelAddAmount2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount2MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 1).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 1).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 1).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount2MouseClicked

    private void jLabelAddAmount2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount2MouseEntered
        jLabelAddAmount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount2MouseEntered

    private void jLabelAddAmount2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount2MouseExited
        jLabelAddAmount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount2MouseExited

    private void jLabelMinusAmount2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount2MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 1).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 1).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount2MouseClicked

    private void jLabelMinusAmount2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount2MouseEntered
        jLabelMinusAmount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount2MouseEntered

    private void jLabelMinusAmount2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount2MouseExited
        jLabelMinusAmount2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount2MouseExited

    private void jLabelAddAmount3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount3MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 2).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 3).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 3).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount3MouseClicked

    private void jLabelAddAmount3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount3MouseEntered
        jLabelAddAmount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount3MouseEntered

    private void jLabelAddAmount3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount3MouseExited
        jLabelAddAmount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount3MouseExited

    private void jLabelMinusAmount3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount3MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 2).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 2).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount3MouseClicked

    private void jLabelMinusAmount3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount3MouseEntered
        jLabelMinusAmount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount3MouseEntered

    private void jLabelMinusAmount3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount3MouseExited
        jLabelMinusAmount3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount3MouseExited

    private void jLabelAddAmount4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount4MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 3).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 3).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 3).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount4MouseClicked

    private void jLabelAddAmount4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount4MouseEntered
        jLabelAddAmount4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount4MouseEntered

    private void jLabelAddAmount4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount4MouseExited
        jLabelAddAmount4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount4MouseExited

    private void jLabelMinusAmount4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount4MouseClicked
       countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 3).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 3).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount4MouseClicked

    private void jLabelMinusAmount4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount4MouseEntered
        jLabelMinusAmount4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount4MouseEntered

    private void jLabelMinusAmount4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount4MouseExited
        jLabelMinusAmount4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount4MouseExited

    private void jLabelAddAmount5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount5MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 4).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 4).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 4).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount5MouseClicked

    private void jLabelAddAmount5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount5MouseEntered
        jLabelAddAmount5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount5MouseEntered

    private void jLabelAddAmount5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount5MouseExited
        jLabelAddAmount5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount5MouseExited

    private void jLabelMinusAmount5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount5MouseClicked
       countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 4).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 4).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount5MouseClicked

    private void jLabelMinusAmount5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount5MouseEntered
        jLabelMinusAmount5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount5MouseEntered

    private void jLabelMinusAmount5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount5MouseExited
        jLabelMinusAmount5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount5MouseExited

    private void jLabelAddAmount6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount6MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 5).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 5).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 5).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount6MouseClicked

    private void jLabelAddAmount6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount6MouseEntered
        jLabelAddAmount6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount6MouseEntered

    private void jLabelAddAmount6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount6MouseExited
        jLabelAddAmount6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount6MouseExited

    private void jLabelMinusAmount6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount6MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 5).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 5).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount6MouseClicked

    private void jLabelMinusAmount6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount6MouseEntered
        jLabelMinusAmount6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount6MouseEntered

    private void jLabelMinusAmount6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount6MouseExited
        jLabelMinusAmount6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount6MouseExited

    private void jLabelAddAmount7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount7MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 6).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 6).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 6).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount7MouseClicked

    private void jLabelAddAmount7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount7MouseEntered
        jLabelAddAmount7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount7MouseEntered

    private void jLabelAddAmount7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount7MouseExited
        jLabelAddAmount7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount7MouseExited

    private void jLabelMinusAmount7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount7MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 6).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 6).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount7MouseClicked

    private void jLabelMinusAmount7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount7MouseEntered
        jLabelMinusAmount7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount7MouseEntered

    private void jLabelMinusAmount7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount7MouseExited
        jLabelMinusAmount7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount7MouseExited

    private void jLabelAddAmount8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount8MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 7).getAmount();
        try {
            Goods g = GoodsDao.findProductForBill(ListBill1.get(pageBill + 7).getItemcode());
            if (am < g.getAmount()) {
                am++;
                ListBill1.get(pageBill + 7).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddAmount8MouseClicked

    private void jLabelAddAmount8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount8MouseEntered
        jLabelAddAmount8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px.png")));
    }//GEN-LAST:event_jLabelAddAmount8MouseEntered

    private void jLabelAddAmount8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddAmount8MouseExited
        jLabelAddAmount8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_new_25px_1.png")));
    }//GEN-LAST:event_jLabelAddAmount8MouseExited

    private void jLabelMinusAmount8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount8MouseClicked
        countProductBill = ListBill1.size();
        setPageBill = (countProductBill % 8 == 0) ? 0 : 1;
        jLabelPageBill2.setText("/" + String.valueOf(countProductBill / 8 + setPageBill));
        int pageBill = (Integer.parseInt(jTextFieldPageBill2.getText()) - 1) * 8;
        int am = ListBill1.get(pageBill + 7).getAmount();
        try {
            if (am > 1) {
                am--;
                ListBill1.get(pageBill + 7).setAmount(am);
                showProductsBill(ListBill1, countProductBill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelMinusAmount8MouseClicked

    private void jLabelMinusAmount8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount8MouseEntered
        jLabelMinusAmount8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px_1.png")));
    }//GEN-LAST:event_jLabelMinusAmount8MouseEntered

    private void jLabelMinusAmount8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinusAmount8MouseExited
        jLabelMinusAmount8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_reduce_25px.png")));
    }//GEN-LAST:event_jLabelMinusAmount8MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JPanel jDashboardQLBH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAdd1;
    private javax.swing.JLabel jLabelAdd10;
    private javax.swing.JLabel jLabelAdd11;
    private javax.swing.JLabel jLabelAdd12;
    private javax.swing.JLabel jLabelAdd2;
    private javax.swing.JLabel jLabelAdd3;
    private javax.swing.JLabel jLabelAdd4;
    private javax.swing.JLabel jLabelAdd5;
    private javax.swing.JLabel jLabelAdd6;
    private javax.swing.JLabel jLabelAdd7;
    private javax.swing.JLabel jLabelAdd8;
    private javax.swing.JLabel jLabelAdd9;
    private javax.swing.JLabel jLabelAddAmount1;
    private javax.swing.JLabel jLabelAddAmount2;
    private javax.swing.JLabel jLabelAddAmount3;
    private javax.swing.JLabel jLabelAddAmount4;
    private javax.swing.JLabel jLabelAddAmount5;
    private javax.swing.JLabel jLabelAddAmount6;
    private javax.swing.JLabel jLabelAddAmount7;
    private javax.swing.JLabel jLabelAddAmount8;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelCustomerNeedPay;
    private javax.swing.JLabel jLabelCustomerNeedPay1;
    private javax.swing.JLabel jLabelCustomerPay;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelDelete1;
    private javax.swing.JLabel jLabelDelete2;
    private javax.swing.JLabel jLabelDelete3;
    private javax.swing.JLabel jLabelDelete4;
    private javax.swing.JLabel jLabelDelete5;
    private javax.swing.JLabel jLabelDelete6;
    private javax.swing.JLabel jLabelDelete7;
    private javax.swing.JLabel jLabelDelete8;
    private javax.swing.JLabel jLabelDiscount;
    private javax.swing.JLabel jLabelDiscountBill;
    private javax.swing.JLabel jLabelDiscountBill1;
    private javax.swing.JLabel jLabelDiscountBill2;
    private javax.swing.JLabel jLabelExcessCash;
    private javax.swing.JLabel jLabelExcessCash1;
    private javax.swing.JLabel jLabelFrameSearchBill1;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JLabel jLabelImage3;
    private javax.swing.JLabel jLabelImage4;
    private javax.swing.JLabel jLabelImage5;
    private javax.swing.JLabel jLabelImage6;
    private javax.swing.JLabel jLabelImage7;
    private javax.swing.JLabel jLabelImage8;
    private javax.swing.JLabel jLabelImageProduct1;
    private javax.swing.JLabel jLabelImageProduct10;
    private javax.swing.JLabel jLabelImageProduct11;
    private javax.swing.JLabel jLabelImageProduct12;
    private javax.swing.JLabel jLabelImageProduct2;
    private javax.swing.JLabel jLabelImageProduct3;
    private javax.swing.JLabel jLabelImageProduct4;
    private javax.swing.JLabel jLabelImageProduct5;
    private javax.swing.JLabel jLabelImageProduct6;
    private javax.swing.JLabel jLabelImageProduct7;
    private javax.swing.JLabel jLabelImageProduct8;
    private javax.swing.JLabel jLabelImageProduct9;
    private javax.swing.JLabel jLabelLeftPageBill1;
    private javax.swing.JLabel jLabelLeftPageBill2;
    private javax.swing.JLabel jLabelMinusAmount1;
    private javax.swing.JLabel jLabelMinusAmount2;
    private javax.swing.JLabel jLabelMinusAmount3;
    private javax.swing.JLabel jLabelMinusAmount4;
    private javax.swing.JLabel jLabelMinusAmount5;
    private javax.swing.JLabel jLabelMinusAmount6;
    private javax.swing.JLabel jLabelMinusAmount7;
    private javax.swing.JLabel jLabelMinusAmount8;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelName2;
    private javax.swing.JLabel jLabelName3;
    private javax.swing.JLabel jLabelName4;
    private javax.swing.JLabel jLabelName5;
    private javax.swing.JLabel jLabelName6;
    private javax.swing.JLabel jLabelName7;
    private javax.swing.JLabel jLabelName8;
    private javax.swing.JLabel jLabelNameProduct1;
    private javax.swing.JLabel jLabelNameProduct10;
    private javax.swing.JLabel jLabelNameProduct11;
    private javax.swing.JLabel jLabelNameProduct12;
    private javax.swing.JLabel jLabelNameProduct2;
    private javax.swing.JLabel jLabelNameProduct3;
    private javax.swing.JLabel jLabelNameProduct4;
    private javax.swing.JLabel jLabelNameProduct5;
    private javax.swing.JLabel jLabelNameProduct6;
    private javax.swing.JLabel jLabelNameProduct7;
    private javax.swing.JLabel jLabelNameProduct8;
    private javax.swing.JLabel jLabelNameProduct9;
    private javax.swing.JLabel jLabelNumOrder;
    private javax.swing.JLabel jLabelNumOrder1;
    private javax.swing.JLabel jLabelNumOrder2;
    private javax.swing.JLabel jLabelNumOrder3;
    private javax.swing.JLabel jLabelNumOrder4;
    private javax.swing.JLabel jLabelNumOrder5;
    private javax.swing.JLabel jLabelNumOrder6;
    private javax.swing.JLabel jLabelNumOrder7;
    private javax.swing.JLabel jLabelNumOrder8;
    private javax.swing.JLabel jLabelOver1;
    private javax.swing.JLabel jLabelOver10;
    private javax.swing.JLabel jLabelOver11;
    private javax.swing.JLabel jLabelOver12;
    private javax.swing.JLabel jLabelOver2;
    private javax.swing.JLabel jLabelOver3;
    private javax.swing.JLabel jLabelOver4;
    private javax.swing.JLabel jLabelOver5;
    private javax.swing.JLabel jLabelOver6;
    private javax.swing.JLabel jLabelOver7;
    private javax.swing.JLabel jLabelOver8;
    private javax.swing.JLabel jLabelOver9;
    private javax.swing.JLabel jLabelPageBill1;
    private javax.swing.JLabel jLabelPageBill2;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelPriceProduct1;
    private javax.swing.JLabel jLabelPriceProduct10;
    private javax.swing.JLabel jLabelPriceProduct11;
    private javax.swing.JLabel jLabelPriceProduct12;
    private javax.swing.JLabel jLabelPriceProduct2;
    private javax.swing.JLabel jLabelPriceProduct3;
    private javax.swing.JLabel jLabelPriceProduct4;
    private javax.swing.JLabel jLabelPriceProduct5;
    private javax.swing.JLabel jLabelPriceProduct6;
    private javax.swing.JLabel jLabelPriceProduct7;
    private javax.swing.JLabel jLabelPriceProduct8;
    private javax.swing.JLabel jLabelPriceProduct9;
    private javax.swing.JLabel jLabelRightPageBill1;
    private javax.swing.JLabel jLabelRightPageBill2;
    private javax.swing.JLabel jLabelSearchBill1;
    private javax.swing.JLabel jLabelSkipToEndPageBill1;
    private javax.swing.JLabel jLabelSkipToEndPageBill2;
    private javax.swing.JLabel jLabelSkipToStartPageBill1;
    private javax.swing.JLabel jLabelSkipToStartPageBill2;
    private javax.swing.JLabel jLabelStaff;
    private javax.swing.JLabel jLabelStaff1;
    private javax.swing.JLabel jLabelStaff2;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JLabel jLabelTotalPrice1;
    private javax.swing.JLabel jLabelTotalPrice2;
    private javax.swing.JLabel jLabelTotalPrice3;
    private javax.swing.JLabel jLabelTotalPrice4;
    private javax.swing.JLabel jLabelTotalPrice5;
    private javax.swing.JLabel jLabelTotalPrice6;
    private javax.swing.JLabel jLabelTotalPrice7;
    private javax.swing.JLabel jLabelTotalPrice8;
    private javax.swing.JLabel jLabelTotalPriceBill;
    private javax.swing.JLabel jLabelTotalPriceBill1;
    private javax.swing.JPanel jPanelControlPageBill1;
    private javax.swing.JPanel jPanelControlPageBill2;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelPay;
    private javax.swing.JPanel jPanelProduct1;
    private javax.swing.JPanel jPanelProduct10;
    private javax.swing.JPanel jPanelProduct11;
    private javax.swing.JPanel jPanelProduct12;
    private javax.swing.JPanel jPanelProduct2;
    private javax.swing.JPanel jPanelProduct3;
    private javax.swing.JPanel jPanelProduct4;
    private javax.swing.JPanel jPanelProduct5;
    private javax.swing.JPanel jPanelProduct6;
    private javax.swing.JPanel jPanelProduct7;
    private javax.swing.JPanel jPanelProduct8;
    private javax.swing.JPanel jPanelProduct9;
    private javax.swing.JPanel jPanelRowBill1;
    private javax.swing.JPanel jPanelRowBill2;
    private javax.swing.JPanel jPanelRowBill3;
    private javax.swing.JPanel jPanelRowBill4;
    private javax.swing.JPanel jPanelRowBill5;
    private javax.swing.JPanel jPanelRowBill6;
    private javax.swing.JPanel jPanelRowBill7;
    private javax.swing.JPanel jPanelRowBill8;
    private javax.swing.JPanel jPanelSelectProduct;
    private javax.swing.JPanel jPanelSelectedProduct;
    private javax.swing.JPanel jPanelShowBill;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextFieldAmount1;
    private javax.swing.JTextField jTextFieldAmount2;
    private javax.swing.JTextField jTextFieldAmount3;
    private javax.swing.JTextField jTextFieldAmount4;
    private javax.swing.JTextField jTextFieldAmount5;
    private javax.swing.JTextField jTextFieldAmount6;
    private javax.swing.JTextField jTextFieldAmount7;
    private javax.swing.JTextField jTextFieldAmount8;
    private javax.swing.JTextField jTextFieldCustomerPay;
    private javax.swing.JTextField jTextFieldDiscount1;
    private javax.swing.JTextField jTextFieldDiscount2;
    private javax.swing.JTextField jTextFieldDiscount3;
    private javax.swing.JTextField jTextFieldDiscount4;
    private javax.swing.JTextField jTextFieldDiscount5;
    private javax.swing.JTextField jTextFieldDiscount6;
    private javax.swing.JTextField jTextFieldDiscount7;
    private javax.swing.JTextField jTextFieldDiscount8;
    private javax.swing.JTextField jTextFieldMoreDiscount;
    private javax.swing.JTextField jTextFieldNote;
    private javax.swing.JTextField jTextFieldPageBill1;
    private javax.swing.JTextField jTextFieldPageBill2;
    private javax.swing.JTextField jTextFieldPrice1;
    private javax.swing.JTextField jTextFieldPrice2;
    private javax.swing.JTextField jTextFieldPrice3;
    private javax.swing.JTextField jTextFieldPrice4;
    private javax.swing.JTextField jTextFieldPrice5;
    private javax.swing.JTextField jTextFieldPrice6;
    private javax.swing.JTextField jTextFieldPrice7;
    private javax.swing.JTextField jTextFieldPrice8;
    private javax.swing.JTextField jTextFieldSearchBill1;
    // End of variables declaration//GEN-END:variables
}
