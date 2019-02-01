package me.ebenezergraham.qb.repository;
/*
ebenezergraham created on 2/1/19
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Long> {

}
