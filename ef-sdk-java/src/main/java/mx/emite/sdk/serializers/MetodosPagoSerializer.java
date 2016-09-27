package mx.emite.sdk.serializers;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.MetodosPago;

public class MetodosPagoSerializer extends JsonSerializer<MetodosPago> implements UserType{

	@Override
	public void serialize(MetodosPago fp, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(fp==null||fp.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeNumber(fp.getIdSat());
	}
	
	private final Class<MetodosPago> clase = MetodosPago.class;	

	
	
    @Override
	public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
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
	public boolean equals(Object x, Object y) throws HibernateException {
        return ObjectUtils.nullSafeEquals(x, y);
    }
 
    
    @Override
	public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }
 
   
    @Override
	public boolean isMutable() {
        return false;
    }

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		Integer n = rs.getInt(names[0]);
        if(rs.wasNull()) {
            return null;
        }
        final MetodosPago es = MetodosPago.id(n);
        if(es==null)
        	 throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " id");
        return es;
		
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor arg3) throws HibernateException, SQLException {
		 if (value == null) {
	            st.setNull(index, Types.INTEGER);
	        } else {
	            st.setInt(index, ((MetodosPago)value).getIdSat());
	        }
		
	}

	
    @Override
	public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }
 
    
    @Override
	public Class<MetodosPago> returnedClass(){return clase;}
 
    
    @Override
	public int[] sqlTypes() {
        return new int[]{Types.INTEGER};
    }
	
	
}
