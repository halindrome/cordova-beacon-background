package com.red_folder.phonegap.plugin.backgroundservice.sample.estimote;

import com.estimote.sdk.Region;

import java.util.UUID;

public class BeaconID {

    private UUID proximityUUID;
    private Integer major;
    private Integer minor;

    public BeaconID(UUID proximityUUID, Integer major, Integer minor) {
        this.proximityUUID = proximityUUID;
        this.major = major;
        this.minor = minor;
    }

    public BeaconID(String UUIDString, Integer major, Integer minor) {
        this(UUID.fromString(UUIDString), major, minor);
    }

    public UUID getProximityUUID() {
        return proximityUUID;
    }

    public Integer getMajor() {
        return major;
    }

    public Integer getMinor() {
        return minor;
    }

    public Region toBeaconRegion() {
        return new Region(toString(), getProximityUUID(), getMajor(), getMinor());
    }

    public String toString() {
        return getProximityUUID().toString() + ":" + getMajor() + ":" + getMinor();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return super.equals(o);
        }

        BeaconID other = (BeaconID) o;

        return getProximityUUID().equals(other.getProximityUUID())
                && getMajor() == other.getMajor()
                && getMinor() == other.getMinor();
    }
}
