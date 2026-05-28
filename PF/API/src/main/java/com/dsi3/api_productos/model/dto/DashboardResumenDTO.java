package com.dsi3.api_productos.model.dto;

public class DashboardResumenDTO {

    private long totalProductosActivos;
    private long mesasDisponibles;
    private long pedidosActivos;
    private long pedidosEntregadosHoy;

    public DashboardResumenDTO() {}

    public DashboardResumenDTO(long totalProductosActivos, long mesasDisponibles,
                                long pedidosActivos, long pedidosEntregadosHoy) {
        this.totalProductosActivos = totalProductosActivos;
        this.mesasDisponibles      = mesasDisponibles;
        this.pedidosActivos        = pedidosActivos;
        this.pedidosEntregadosHoy  = pedidosEntregadosHoy;
    }

    public long getTotalProductosActivos() { return totalProductosActivos; }
    public void setTotalProductosActivos(long v) { this.totalProductosActivos = v; }
    public long getMesasDisponibles()      { return mesasDisponibles; }
    public void setMesasDisponibles(long v)      { this.mesasDisponibles      = v; }
    public long getPedidosActivos()        { return pedidosActivos; }
    public void setPedidosActivos(long v)        { this.pedidosActivos        = v; }
    public long getPedidosEntregadosHoy()  { return pedidosEntregadosHoy; }
    public void setPedidosEntregadosHoy(long v)  { this.pedidosEntregadosHoy  = v; }
}
