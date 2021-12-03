public class FieldNamingConventionsSample {
    Integer instanceField; // This is in camel case, so it's ok

    Integer INSTANCE_FIELD; // This will be reported unless you change the regex
}
