package com.dao;
import java.sql.Date;

	import java.sql.*;
	import java.util.*;
	import com.model.Patient;
	import java.text.SimpleDateFormat;

	public class HospitalDAO {
	    private static Connection getConnection() throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
	    }

	    public static int addPatient(Patient p) throws Exception {
	        Connection con = getConnection();
	        String sql = "INSERT INTO Patients VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, p.getPatientID());
	        ps.setString(2, p.getPatientName());
	        ps.setInt(3, p.getAge());
	        ps.setString(4, p.getGender());
	        ps.setDate(5, new java.sql.Date(p.getAdmissionDate().getTime()));
	        ps.setString(6, p.getAilment());
	        ps.setString(7, p.getAssignedDoctor());
	        return ps.executeUpdate();
	    }

	    public static int updatePatient(Patient p) throws Exception {
	        Connection con = getConnection();
	        String sql = "UPDATE Patients SET PatientName=?, Age=?, Gender=?, AdmissionDate=?, Ailment=?, AssignedDoctor=? WHERE PatientID=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, p.getPatientName());
	        ps.setInt(2, p.getAge());
	        ps.setString(3, p.getGender());
	        ps.setDate(4, new java.sql.Date(p.getAdmissionDate().getTime()));
	        ps.setString(5, p.getAilment());
	        ps.setString(6, p.getAssignedDoctor());
	        ps.setInt(7, p.getPatientID());
	        return ps.executeUpdate();
	    }

	    public static int deletePatient(int id) throws Exception {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("DELETE FROM Patients WHERE PatientID=?");
	        ps.setInt(1, id);
	        return ps.executeUpdate();
	    }

	    public static List<Patient> getAllPatients() throws Exception {
	        List<Patient> list = new ArrayList<>();
	        Connection con = getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM Patients");
	        while (rs.next()) {
	            Patient p = new Patient();
	            p.setPatientID(rs.getInt(1));
	            p.setPatientName(rs.getString(2));
	            p.setAge(rs.getInt(3));
	            p.setGender(rs.getString(4));
	            p.setAdmissionDate(rs.getDate(5));
	            p.setAilment(rs.getString(6));
	            p.setAssignedDoctor(rs.getString(7));
	            list.add(p);
	        }
	        return list;
	    }

	    public static List<Patient> getPatientsByDateRange(java.util.Date start, java.util.Date end) throws Exception {
	        List<Patient> list = new ArrayList<>();
	        Connection con = getConnection();
	        String sql = "SELECT * FROM Patients WHERE AdmissionDate BETWEEN ? AND ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setDate(1, new java.sql.Date(start.getTime()));
	        ps.setDate(2, new java.sql.Date(end.getTime()));
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Patient p = new Patient();
	            p.setPatientID(rs.getInt("PatientID"));
	            p.setPatientName(rs.getString("PatientName"));
	            p.setAge(rs.getInt("Age"));
	            p.setGender(rs.getString("Gender"));
	            p.setAdmissionDate(rs.getDate("AdmissionDate"));
	            p.setAilment(rs.getString("Ailment"));
	            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
	            list.add(p);
	        }
	        return list;
	    }

	    public static List<Patient> getPatientsByAilment(String ailment) throws Exception {
	        List<Patient> list = new ArrayList<>();
	        Connection con = getConnection();
	        String sql = "SELECT * FROM Patients WHERE Ailment = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, ailment);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Patient p = new Patient();
	            p.setPatientID(rs.getInt("PatientID"));
	            p.setPatientName(rs.getString("PatientName"));
	            p.setAge(rs.getInt("Age"));
	            p.setGender(rs.getString("Gender"));
	            p.setAdmissionDate(rs.getDate("AdmissionDate"));
	            p.setAilment(rs.getString("Ailment"));
	            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
	            list.add(p);
	        }
	        return list;
	    }

	    public static List<Patient> getPatientsByDoctor(String doctor) throws Exception {
	        List<Patient> list = new ArrayList<>();
	        Connection con = getConnection();
	        String sql = "SELECT * FROM Patients WHERE AssignedDoctor = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, doctor);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Patient p = new Patient();
	            p.setPatientID(rs.getInt("PatientID"));
	            p.setPatientName(rs.getString("PatientName"));
	            p.setAge(rs.getInt("Age"));
	            p.setGender(rs.getString("Gender"));
	            p.setAdmissionDate(rs.getDate("AdmissionDate"));
	            p.setAilment(rs.getString("Ailment"));
	            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
	            list.add(p);
	        }
	        return list;
	    }
	}



