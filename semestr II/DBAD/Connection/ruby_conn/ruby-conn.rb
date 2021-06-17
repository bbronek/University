require 'pg'
begin
  conn = PG.connect(:dbname => 'projekt1',:user => 'postgres',:password => "postgres")

  rs = conn.exec "SELECT * FROM Pisarze"

  rs.each { |row| p row }


rescue PG::Error => e
  puts e.message

ensure

  rs.clear if rs
  conn.close if conn
end


