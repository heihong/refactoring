package fr.soat.cleancoders.examples.draft;

class CsvWriter { //// FIXME: 07/03/2018  j'ai un doute dessus - peut-être pas nécessaire
    void write(String[][] lines) {
        for (String[] line : lines)
            writeLine(line);
    }

    private void writeLine(String[] fields) {
        if (fields.length == 0)
            System.out.println();
        else {
            writeField(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                System.out.print(",");
                writeField(fields[i]);
            }
            System.out.println();
        }
    }

    private void writeField(String field) {
        if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
            writeQuoted(field);
        else
            System.out.print(field);
    }

    private void writeQuoted(String field) {
        System.out.print('\"');
        for (int i = 0; i < field.length(); i++) {
            char c = field.charAt(i);
            if (c == '\"')
                System.out.print("\"\"");
            else
                System.out.print(c);
        }
        System.out.print('\"');
    }
}
