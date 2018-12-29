package com.soft1841.sm.controller;
import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.until.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.layout.StackPane;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GoodsAnalysisController implements Initializable{
    @FXML
    private StackPane pieChartPane, barChartPane;
    private TypeService typeService = ServiceFactory.getTypeServiceInstance ();
    private GoodsService goodsService = ServiceFactory.getGoodsServiceInstance ();
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList ();

    @Override
    public void initialize(URL location , ResourceBundle resources) {
        //初始化饼图的方法
        initPieChart ();
        //初始化柱状图
        initBarChart ();
    }

    private void initPieChart() {
        List<Type> typeList = typeService.getAllTypes ();
        for (Type type : typeList) {
            int count = goodsService.countByType ( type.getId () );
            pieChartData.add ( new PieChart.Data ( type.getTypeName () , count ) );
        }
        final PieChart chart = new PieChart ( pieChartData );
        chart.setTitle ( "按商品类别统计饼图" );
        pieChartPane.getChildren ().add ( chart );
    }

    private void initBarChart() {
        final CategoryAxis x = new CategoryAxis ();
        final NumberAxis y = new NumberAxis ();
        final BarChart<String, Number> bc =
                new BarChart<> ( x , y );
        bc.setTitle ( "根据类别统计柱形图" );
        x.setLabel ( "商品类别" );
        y.setLabel ( "商品数量" );
        XYChart.Series series1 = new XYChart.Series ();
        series1.setName ( "2018年统计数据" );
        List<Type> typeList = typeService.getAllTypes ();
        for (Type type : typeList) {
            int count = goodsService.countByType ( type.getId () );
            series1.getData ().add ( new XYChart.Data ( type.getTypeName () , count ) );
        }
        bc.getData ().addAll ( series1 );
        barChartPane.getChildren ().add ( bc );
    }
}