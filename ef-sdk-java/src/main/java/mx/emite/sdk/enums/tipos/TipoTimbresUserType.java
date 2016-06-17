package mx.emite.sdk.enums.tipos;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import mx.emite.sdk.enums.TipoTimbres;

public class TipoTimbresUserType implements UserType{

	@Override
	public int[] sqlTypes() {
	        return new int[]{Types.INTEGER};
	}
	
	
	@Override
	public Class<TipoTimbres> returnedClass() {
		return TipoTimbres.class;
	}
	
	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return ObjectUtils.nullSafeEquals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		Integer id = rs.getInt(names[0]);
        if(rs.wasNull()) {
            return null;
        }
        
        for(TipoTimbres value : returnedClass().getEnumConstants()) {
            if(id.equals(value.getId())) {
                return value;
            }
        }
        throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " id");
		
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor arg3) throws HibernateException, SQLException {
		 if (value == null) {
	            st.setNull(index, Types.INTEGER);
	        } else {
	            st.setInt(index, ((TipoTimbres)value).getId());
	        }
		
	}

	  @Override
	public Object deepCopy(Object value) throws HibernateException {
	        return value;
	    }
	 
	    
	    @Override
		public Serializable disassemble(Object value) throws HibernateException {
	        return (Serializable)value;
	    }
	
	
	@Override
	public boolean isMutable() {
		return false;
	}

	 @Override
	public Object assemble(Serializable cached, Object owner)
	            throws HibernateException {
	        return cached;
	    }
	 
	 
	 @Override
	public Object replace(Object original, Object target, Object owner)
	            throws HibernateException {
	        return original;
	    }
}
