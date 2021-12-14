package com.machine.dragon.starter.mybatis.handler;

import com.machine.dragon.common.core.envm.DragonBaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = {DragonBaseEnum.class})
public class DragonEnumTypeHandler<E extends DragonBaseEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    public DragonEnumTypeHandler(Class<E> type) {
        if (null == type) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, e.getCode());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int columnValue = resultSet.getInt(columnName);
        return resultSet.wasNull() ? null : this.getEnum(columnValue);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int columnValue = resultSet.getInt(columnIndex);
        return resultSet.wasNull() ? null : this.getEnum(columnValue);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int columnValue = callableStatement.getInt(columnIndex);
        return callableStatement.wasNull() ? null : this.getEnum(columnValue);
    }

    private E getEnum(Integer code) {
        for (E e : this.type.getEnumConstants()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举编码：" + code);
    }

}
