<template>
    <div>
        <apexchart 
                width="800" 
                :type="type" 
                :options="options"
                :series="series"
                ref="barChart"
        ></apexchart>
    </div>
</template>

<script>
    import BaseUIComponent from './base-ui/BaseUIComponent';
    import VueApexCharts from 'vue-apexcharts';

    export default {
        mixins: [BaseUIComponent],
        name: 'PurchaseCountByPetIdChart',
        components: {
            'apexchart': VueApexCharts,
        },
        data: () => ({
            type: "bar",
            options: {
                chart: {
                    id: "purchaseCountByPetId-bar"
                },
                xaxis: {
                    categories: []
                },
            },
            series: [
                {
                    data: []
                }
            ],
        }),
        created() {
            this.path = "/purchaseCounts"
            this.getValue();
            this.purchaseCount = temp.data._embedded.purchaseCounts;
            this.categories = [ "petId" ];
            this.data = [ "count" ];

            const type = "bar"
            this.setValue(type);

            this.$refs.barChart.refresh();
        },
        methods: {
        }
    }
</script>

