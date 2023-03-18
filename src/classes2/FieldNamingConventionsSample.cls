public class FieldNamingConventionsSample {
    Integer instanceField; // This is in camel case, so it's ok

    Integer INSTANCE_FIELD; // should be reported as "FieldNamingConventions" (prio 1, error)
}
