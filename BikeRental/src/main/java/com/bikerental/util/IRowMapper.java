package com.bikerental.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bikerental.model.Bike;

public interface IRowMapper {
	List <Bike> mapRow(ResultSet resultSet) throws SQLException;

}
