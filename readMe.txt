Default Hibernate Values

<hibernate-mapping
         schema="schemaName"                          (1)
         catalog="catalogName"                        (2)
         default-cascade="cascade_style"              (3)
         default-access="field|property|ClassName"    (4)
         default-lazy="true|false"                    (5)
         auto-import="true|false"                     (6)
         package="package.name"                       (7)
 />
 
 By default, the auto-import attribute allows you to use unqualified class names in the query language.
 
 1	schema (optional): the name of a database schema.
2	catalog (optional): the name of a database catalog.
3	default-cascade (optional - defaults to none): a default cascade style.
4	default-access (optional - defaults to property): the strategy Hibernate should use for accessing all properties. It can be a custom implementation of PropertyAccessor.
5	default-lazy (optional - defaults to true): the default value for unspecified lazy attributes of class and collection mappings.
6	auto-import (optional - defaults to true): specifies whether we can use unqualified class names of classes in this mapping in the query language.
7	package (optional): specifies a package prefix to use for unqualified class names in the mapping document.