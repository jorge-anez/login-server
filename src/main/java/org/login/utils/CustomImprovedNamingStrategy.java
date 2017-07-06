package org.login.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import static com.google.common.base.CaseFormat.*;

/**
 * Created by user on 7/6/2017.
 */

public class CustomImprovedNamingStrategy extends ImplicitNamingStrategyLegacyHbmImpl {

    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(
                UPPER_CAMEL.to(LOWER_UNDERSCORE, name.getText()),
                name.isQuoted()
        );
    }

    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier(
                LOWER_CAMEL.to(LOWER_UNDERSCORE, name.getText()),
                name.isQuoted()
        );
    }

}
