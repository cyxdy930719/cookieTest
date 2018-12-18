package com.neuedu.untiltest;

import java.sql.ResultSet;

public interface RowMap<T> {
    public T RowMapping(ResultSet rs);
}
