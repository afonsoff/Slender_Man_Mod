package net.minecraft.util;

public class ChunkCoordinates implements Comparable
{
    public int posX;

    /** the y coordinate */
    public int posY;

    /** the z coordinate */
    public int posZ;

    public ChunkCoordinates() {}

    public ChunkCoordinates(int par1, int par2, int par3)
    {
        this.posX = par1;
        this.posY = par2;
        this.posZ = par3;
    }

    public ChunkCoordinates(ChunkCoordinates par1ChunkCoordinates)
    {
        this.posX = par1ChunkCoordinates.posX;
        this.posY = par1ChunkCoordinates.posY;
        this.posZ = par1ChunkCoordinates.posZ;
    }

    public boolean equals(Object par1Obj)
    {
        if (!(par1Obj instanceof ChunkCoordinates))
        {
            return false;
        }
        else
        {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)par1Obj;
            return this.posX == chunkcoordinates.posX && this.posY == chunkcoordinates.posY && this.posZ == chunkcoordinates.posZ;
        }
    }

    public int hashCode()
    {
        return this.posX + this.posZ << 8 + this.posY << 16;
    }

    /**
     * Compare the coordinate with another coordinate
     */
    public int compareChunkCoordinate(ChunkCoordinates par1ChunkCoordinates)
    {
        return this.posY == par1ChunkCoordinates.posY ? (this.posZ == par1ChunkCoordinates.posZ ? this.posX - par1ChunkCoordinates.posX : this.posZ - par1ChunkCoordinates.posZ) : this.posY - par1ChunkCoordinates.posY;
    }

    public void set(int par1, int par2, int par3)
    {
        this.posX = par1;
        this.posY = par2;
        this.posZ = par3;
    }

    /**
     * Returns the squared distance between this coordinates and the coordinates given as argument.
     */
    public float getDistanceSquared(int par1, int par2, int par3)
    {
        int l = this.posX - par1;
        int i1 = this.posY - par2;
        int j1 = this.posZ - par3;
        return (float)(l * l + i1 * i1 + j1 * j1);
    }

    /**
     * Return the squared distance between this coordinates and the ChunkCoordinates given as argument.
     */
    public float getDistanceSquaredToChunkCoordinates(ChunkCoordinates par1ChunkCoordinates)
    {
        return this.getDistanceSquared(par1ChunkCoordinates.posX, par1ChunkCoordinates.posY, par1ChunkCoordinates.posZ);
    }

    public int compareTo(Object par1Obj)
    {
        return this.compareChunkCoordinate((ChunkCoordinates)par1Obj);
    }
}
