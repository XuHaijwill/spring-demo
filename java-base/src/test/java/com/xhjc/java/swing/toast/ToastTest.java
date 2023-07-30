package com.xhjc.java.swing.toast;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class ToastTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToastFrame::new);
    }
}