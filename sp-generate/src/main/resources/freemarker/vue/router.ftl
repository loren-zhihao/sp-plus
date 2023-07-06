// 定义菜单列表
var menuList =	[
<#list cfg.tableList as t>
	{
		name: '${t.varName}',
		path: '/${t.varName}',
		component: Layout,
        meta: {
          title: '${t.tableComment}',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: '${t.varName}-list',
                path: '${t.varName}-list',
                component: () => import('@/sp-views/${t.kebabName}/${t.kebabName}-list.vue'),
                meta: { title: '${t.tableComment}-列表' }
            },
            {
                name: '${t.varName}-add',
                path: '${t.varName}-add',
                component: () => import('@/sp-views/${t.kebabName}/${t.kebabName}-add.vue'),
                meta: { title: '${t.tableComment}-新增' }
            },
            {
                name: '${t.varName}-info',
                path: '${t.varName}-info',
                component: () => import('@/sp-views/${t.kebabName}/${t.kebabName}-info.vue'),
                meta: { title: '${t.tableComment}-详情' }
            },
		]
	},
</#list>
]