public class ReportDAO {

    private DataSource dataSource;

    public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                int month,
                                                int year) throws SQLException {

        String sql = """
            SELECT *
            FROM report_entries
            WHERE account_id = ?
              AND MONTH(entry_date) = ?
              AND YEAR(entry_date) = ?
            """;

        List<ReportEntry> entries = new ArrayList<>();
		// here using try-with-resource we do not have to write finaly block to close Connection 
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    entries.add(mapRow(rs));
                }
            }
        }

        return entries;
    }
}