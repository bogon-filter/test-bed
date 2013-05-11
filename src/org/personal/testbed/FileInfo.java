package org.personal.testbed;

public class FileInfo implements Comparable{

    private final String fileName;
    private final Long timeStamp;

    public FileInfo(String fileName, Long timeStamp){
        this.fileName = fileName;
        this.timeStamp = timeStamp;
    }

    public String getFileName() {
        return fileName;
    }
    public Long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "FileInfo [fileName=" + fileName + ", timeStamp=" + timeStamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FileInfo other = (FileInfo) obj;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (timeStamp == null) {
            if (other.timeStamp != null)
                return false;
        } else if (!timeStamp.equals(other.timeStamp))
            return false;
        return true;
    }


    @Override
    public int compareTo(Object arg0) {

        if (!(arg0 instanceof FileInfo)) {
            throw new ClassCastException("cannot compare elements of different class");
        }
        FileInfo other = (FileInfo) arg0;
        if (this.getTimeStamp() == other.getTimeStamp()) {
            return 0;
        }
        if (this.getTimeStamp() < other.timeStamp) {
            return -1;
        }
        return 1;
    }

}
